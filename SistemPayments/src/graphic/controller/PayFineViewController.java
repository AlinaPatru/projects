package graphic.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import graphic.GraphicMethods;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Client;
import model.ClientTable;
import model.FinesTable;

public class PayFineViewController 
{
	@FXML
    private TableView<FinesTable> relationTable=new TableView<FinesTable>();
    @FXML
    private TableColumn<FinesTable, String> providerColumn;
    @FXML
    private TableColumn<FinesTable, Double> fineColumn;
    @FXML
    private Label depositLabel;
    @FXML
    private TextField depositField;

    private Client client =new Client();
    
    private GraphicMethods graphicMethods=new GraphicMethods();
    
    private Socket socketConnection;

    private ObservableList<FinesTable> relationData = FXCollections.observableArrayList();


    public PayFineViewController()
    {
    	
    }
    
    public void setClient(Client client) 
    {
		this.client=client;
	}
    
    public void setRelationTable() throws UnknownHostException, IOException, ClassNotFoundException
    {
    	depositField.setText(client.getDeposit()+"");
    	
    	String message=graphicMethods.createDataForServerCreateFinesTable(client.getIdClient());
    	socketConnection = new Socket("127.0.0.1", 7004);
		ObjectOutputStream clientOutputStream = new ObjectOutputStream(socketConnection.getOutputStream());
		ObjectInputStream clientInputStream = new ObjectInputStream(socketConnection.getInputStream());
		
		clientOutputStream.writeObject(message);
		
		int n=(int) clientInputStream.readObject();
		if(n>0)
		{
	        for(int i=0;i<n;i++)
			{
	        	relationData.add((FinesTable) clientInputStream.readObject());
			}
		}
    	
    	providerColumn.setCellValueFactory(new PropertyValueFactory<>("providerName"));
    	fineColumn.setCellValueFactory(new PropertyValueFactory<>("fine"));
		
		relationTable.setItems(relationData);
    }
    
    @FXML
    private void payFine(ActionEvent event) throws IOException
    {
    	int selectedIndex = relationTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) 
        {
        	if(relationData.get(selectedIndex).getFine()<=client.getDeposit())
        	{
	        	String message="payFine^"+relationData.get(selectedIndex).getIdRelation();
	        	socketConnection = new Socket("127.0.0.1", 7004);
	    		ObjectOutputStream clientOutputStream = new ObjectOutputStream(socketConnection.getOutputStream());
	    		ObjectInputStream clientInputStream = new ObjectInputStream(socketConnection.getInputStream());
	    		
	    		clientOutputStream.writeObject(message);
	    		
	        	FinesTable fine=relationTable.getItems().remove(selectedIndex);
	        	relationData.remove(fine);
	        	clientOutputStream.writeObject(client);
	        	clientOutputStream.writeObject(fine);
	        	try {
					client=(Client) clientInputStream.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	depositField.setText(client.getDeposit()+"");
        	}
        	else
        		graphicMethods.showAlert("Payment Error", "You don't have enough money to pay the fine");

        } 
        else 
        {
        	graphicMethods.showAlert("No Selection Error", "Please select a fine in the table.");
        }
    }
    
    @FXML
    private void back(ActionEvent event)throws Exception 
    {
    	socketConnection = new Socket("127.0.0.1", 7004);
		ObjectOutputStream clientOutputStream = new ObjectOutputStream(socketConnection.getOutputStream());
		ObjectInputStream clientInputStream = new ObjectInputStream(socketConnection.getInputStream());
		
		Stage primaryStage=new Stage();
		
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/graphic/view/ClientView.fxml"));
		Parent root = (Parent)fxmlLoader.load();
		ClientViewController controller = fxmlLoader.<ClientViewController>getController();
        controller.setClient(client);
        
        clientOutputStream.writeObject("createClientTable^"+client.getIdClient());
        int n=(int) clientInputStream.readObject();
        ObservableList<ClientTable> clientTable = FXCollections.observableArrayList();
        for(int i=0;i<n;i++)
		{
        	clientTable.add((ClientTable) clientInputStream.readObject());
		}
        
        List<String> notifications  = new ArrayList<>();
        int m=(int) clientInputStream.readObject();
        for(int i=0;i<m;i++)
		{
        	notifications.add((String) clientInputStream.readObject());
		}
        
        controller.setNotifications(notifications);
  		controller.setClientTableData(clientTable);
  		controller.setClientTable();
  		
		Scene scene = new Scene(root,900,600);

		scene.getStylesheets().add(getClass().getResource("/graphic/myApp2.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		
		graphicMethods.closeStage(event);
    }
    

}
