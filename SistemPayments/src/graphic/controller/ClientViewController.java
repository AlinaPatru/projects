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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Client;
import model.ClientTable;
import validation.MyException;
import validation.GraphicValidations;

public class ClientViewController 
{

	@FXML
    private TableView<ClientTable> billTable=new TableView<ClientTable>();
	@FXML
    private TableColumn<ClientTable,Integer> idBillColumn;
    @FXML
    private TableColumn<ClientTable, String> providerNameColumn;
    @FXML
    private TableColumn<ClientTable, String> serviceColumn;
    @FXML
    private TableColumn<ClientTable, Double> priceColumn;
    @FXML
    private TableColumn<ClientTable,String> limitDateColumn;
    @FXML
    private Label welcomeLabel;
	@FXML
    private Label depositLabel;
	@FXML
    private Label addToDepositLabel;
    @FXML
    private TextField depositField;
    @FXML
    private TextField addToDepositField;
    @FXML
    private Button notification;
    
    private GraphicValidations graphicValidations=new GraphicValidations();
	
	private GraphicMethods graphicMethods=new GraphicMethods();
    
    private Stage primaryStage=new Stage();
    
    private Client client =new Client();
    
    private List<String> notifications = new ArrayList<>();
    
    private Socket socketConnection;

    private ObservableList<ClientTable> clientTableData = FXCollections.observableArrayList();

    public ClientViewController()
    {
       
    }
    
    public void setClientTableData(ObservableList<ClientTable> allBills) 
    {
		this.clientTableData=allBills;
	}
    
    public void setClient(Client client) 
    {
		this.client=client;
	}
    public Client getClient() 
    {
		return this.client;
	}
    
    public void setNotifications(List<String> notifications)
    {
    	this.notifications = notifications;
    }

    
    public void setClientTable() throws UnknownHostException, IOException, ClassNotFoundException
    {	
    	depositField.setText(client.getDeposit()+"");
    	welcomeLabel.setText("Welcome "+client.getName()+"!");
    	notification.setText(""+ notifications.size());
        
    	idBillColumn.setCellValueFactory(new PropertyValueFactory<>("idBill"));
    	providerNameColumn.setCellValueFactory(new PropertyValueFactory<>("providerName"));
		serviceColumn.setCellValueFactory(new PropertyValueFactory<>("providerService"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		limitDateColumn.setCellValueFactory(new PropertyValueFactory<>("limitDate"));
		
		

		billTable.setItems(clientTableData);
    }
    	
	@FXML
    private void addToDeposit(ActionEvent event) throws Exception 
	{
		try
		{
			
			String sum=addToDepositField.getText();
			graphicValidations.validationAddToDeposit(sum);
			
			socketConnection = new Socket("127.0.0.1", 7004);
			ObjectOutputStream clientOutputStream = new ObjectOutputStream(socketConnection.getOutputStream());
			ObjectInputStream clientInputStream = new ObjectInputStream(socketConnection.getInputStream());
			
    		String message=graphicMethods.createDataForServerAddToDeposit(client, sum);
    		clientOutputStream.writeObject(message);
    		
    		client=(Client) clientInputStream.readObject();
			depositField.setText(client.getDeposit()+"");
			
			socketConnection.close();
			addToDepositField.setText("");
			
		}
		catch(MyException ex)
		{
			 graphicMethods.showAlert("Add to deposit Error", ex.getMessage());
		}
    }
	
	@FXML
    private void payBill(ActionEvent event) throws IOException 
	{
        int selectedIndex = billTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) 
        {
        	ClientTable ct=billTable.getItems().get(selectedIndex);
        	billTable.getItems().remove(selectedIndex);
        	
        	try 
        	{
        		graphicValidations.validationDeleteFromDeposit(client, ct.getPrice());
        		socketConnection = new Socket("127.0.0.1", 7004);
    			ObjectOutputStream clientOutputStream = new ObjectOutputStream(socketConnection.getOutputStream());
    			ObjectInputStream clientInputStream = new ObjectInputStream(socketConnection.getInputStream());
    			
        		String message=graphicMethods.createDataForServerDeleteFromDeposit(client.getIdClient(),ct.getPrice(),ct.getIdBill());
        		clientOutputStream.writeObject(message);
        		
				client=(Client) clientInputStream.readObject();
				
	        	depositField.setText(client.getDeposit()+"");
			} 
        	catch (MyException | ClassNotFoundException e) 
        	{
        		graphicMethods.showAlert("No Selection Error", e.getMessage());
			}
        } 
        else 
        {
        	graphicMethods.showAlert("No Selection Error", "Please select a bill in the table.");
        }
    }
	
	@FXML
    private void changeClientData(ActionEvent event) throws Exception
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/graphic/view/ClientChangeDataView.fxml"));
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root,400,300);
        primaryStage.setUserData(client);
        primaryStage.initModality(Modality. APPLICATION_MODAL);
		scene.getStylesheets().add(getClass().getResource("/graphic/myApp2.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	    
    }
	
	@FXML
    private void seeFines(ActionEvent event) throws Exception
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/graphic/view/PayFineView.fxml"));
		Parent root = (Parent)fxmlLoader.load();
		PayFineViewController controller = fxmlLoader.<PayFineViewController>getController();
        controller.setClient(client);
        controller.setRelationTable();
		Scene scene = new Scene(root,500,400);
		scene.getStylesheets().add(getClass().getResource("/graphic/myApp2.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		graphicMethods.closeStage(event);
	}
	
	@FXML
    private void subscribe(ActionEvent event) throws Exception
	{
  		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/graphic/view/ChooseProviderView.fxml"));
		Parent root = (Parent)fxmlLoader.load();
		ChooseProviderViewController controller = fxmlLoader.<ChooseProviderViewController>getController();
        controller.setClient(client);
        controller.setChoice(0);
        controller.setProviderTable();
		Scene scene = new Scene(root,600,400);
		scene.getStylesheets().add(getClass().getResource("/graphic/myApp2.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	    
    }
	
	@FXML
    private void unsubscribe(ActionEvent event) throws Exception
	{
  		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/graphic/view/ChooseProviderView.fxml"));
		Parent root = (Parent)fxmlLoader.load();
		ChooseProviderViewController controller = fxmlLoader.<ChooseProviderViewController>getController();
        controller.setClient(client);
        controller.setChoice(1);
        controller.setProviderTable();
		Scene scene = new Scene(root,600,400);
		scene.getStylesheets().add(getClass().getResource("/graphic/myApp2.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	    
    }
	
	@FXML
    private void logout(ActionEvent event)throws Exception 
	{
		graphicMethods.loadStage("/graphic/view/LoginView.fxml", 700, 500);
		
		socketConnection = new Socket("127.0.0.1", 7004);
		ObjectOutputStream clientOutputStream = new ObjectOutputStream(socketConnection.getOutputStream());
		
		String message="logout";
		clientOutputStream.writeObject(message);
		
		graphicMethods.closeStage(event);
    }
	
	@FXML
    private void viewNotification(ActionEvent event) throws Exception
	{
		Stage primaryStage1=new Stage();
		primaryStage1.initStyle(StageStyle.UNDECORATED);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/graphic/view/ShowNotificationView.fxml"));
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root,300,300);
        primaryStage1.setUserData(client);
        ShowNotificationViewController controller = fxmlLoader.<ShowNotificationViewController>getController();
        controller.setNotifications(notifications);
        controller.setScene();
		scene.getStylesheets().add(getClass().getResource("/graphic/myApp2.css").toExternalForm());
		primaryStage1.setScene(scene);
		primaryStage1.initModality(Modality. APPLICATION_MODAL);
		primaryStage1.show();
	    
    }

}
