package graphic.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Client;
import model.Provider;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import graphic.GraphicMethods;


public class ChooseProviderViewController 
{
	@FXML
    private TableView<Provider> providerTable=new TableView<Provider>();
	@FXML
    private TableColumn<Provider,Integer> idProviderColumn;
    @FXML
    private TableColumn<Provider, String> providerNameColumn;
    @FXML
    private TableColumn<Provider, String> serviceColumn;

    private Client client =new Client();
    
    private GraphicMethods graphicMethods=new GraphicMethods();
    
    private Socket socketConnection;
    
    private int choice;

    private ObservableList<Provider> providerData = FXCollections.observableArrayList();

    public ChooseProviderViewController()
    {
    	
    }
    
    public void setProviderData(ObservableList<Provider> allBills) 
    {
		this.providerData=allBills;
	}
    
    public void setClient(Client client) 
    {
		this.client=client;
	}
    
    public void setChoice(int choice) 
    {
		this.choice=choice;
	}
    
    public int getChoice() 
    {
		return this.choice;
	}
    
    public void setProviderTable() throws UnknownHostException, IOException, ClassNotFoundException
    {
    	String message;
    	if(getChoice()==0)
    	{
    		message=graphicMethods.createDataForServerSubscribe(client.getIdClient());
    	}
    	else
    	{
    		message=graphicMethods.createDataForServerUnsubscribe(client.getIdClient());
    	}
    	
    	socketConnection = new Socket("127.0.0.1", 7004);
		ObjectOutputStream clientOutputStream = new ObjectOutputStream(socketConnection.getOutputStream());
		ObjectInputStream clientInputStream = new ObjectInputStream(socketConnection.getInputStream());
		
		clientOutputStream.writeObject(message);
		
		int n=(int) clientInputStream.readObject();
        for(int i=0;i<n;i++)
		{
        	providerData.add((Provider) clientInputStream.readObject());
		}
    	
    	idProviderColumn.setCellValueFactory(new PropertyValueFactory<>("idProvider"));
    	providerNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		serviceColumn.setCellValueFactory(new PropertyValueFactory<>("service"));
		
		providerTable.setItems(providerData);
    }
    
    @FXML
    private void selectProvider(ActionEvent event)throws Exception 
	{
    	String message;
    	int selectedIndex = providerTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) 
        {
        	if(getChoice()==0)
        	{
        		message="createRelation";
        	}
        	else
        	{
        		message="deleteRelation";
        	}

        	socketConnection = new Socket("127.0.0.1", 7004);
    		ObjectOutputStream clientOutputStream = new ObjectOutputStream(socketConnection.getOutputStream());
    		
    		clientOutputStream.writeObject(message);
    		
        	Provider provider=providerTable.getItems().remove(selectedIndex);
        	providerData.remove(provider);
        	clientOutputStream.writeObject(client);
        	clientOutputStream.writeObject(provider);

        } 
        else 
        {
        	graphicMethods.showAlert("No Selection Error", "Please select a provider in the table.");
        }
    	
    }
    
    @FXML
    private void back(ActionEvent event)throws Exception 
	{
    	graphicMethods.closeStage(event);
    }
}
