package graphic.controller;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Client;
import model.ClientTable;
import model.Provider;
import model.ProviderTable;
import validation.MyException;
import validation.GraphicValidations;

public class LoginViewController 
{
	
	@FXML
	private Label noAccount;
	@FXML
	private Label usernameLabel;
	@FXML
	private Label passwordLabel;
	@FXML
	private TextField usernameField;
	@FXML
	private PasswordField passwordField;
	
	private GraphicValidations graphicValidations=new GraphicValidations();
	
	private GraphicMethods graphicMethods=new GraphicMethods();
	
	private Stage primaryStage=new Stage();
	
	private Client client=new Client();
	
	private Provider provider=new Provider();
	
	public LoginViewController()
    {
    	
    }
	
	 @FXML
     private void login(ActionEvent event) throws Exception
	 {
		 String username=usernameField.getText();
		 String password=passwordField.getText();

		try
		{
			 graphicValidations.validationLogin(username, password);

			 Socket socketConnection = new Socket("127.0.0.1", 7004);
			 ObjectOutputStream clientOutputStream = new ObjectOutputStream(socketConnection.getOutputStream());
			 ObjectInputStream clientInputStream = new ObjectInputStream(socketConnection.getInputStream());
			 
	         String message = graphicMethods.createDataForServerLogin(username, password);
	         clientOutputStream.writeObject(message);
	         
	         String confirmation = (String)clientInputStream.readObject();
	         
	         if(confirmation.equals("succes"))
	 	 	 {
	 	 		Object object;
	 	 		object = clientInputStream.readObject();
	 	 		
	 	 		
	 	 		if(object instanceof Client)
	 	 		{
	 	 			client=(Client)object;
	 	 			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/graphic/view/ClientView.fxml"));
					Parent root = (Parent)fxmlLoader.load();
					ClientViewController controller = fxmlLoader.<ClientViewController>getController();
	                controller.setClient(client);
	             
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
	          		controller.setClientTableData(clientTable);
	          		controller.setNotifications(notifications);
	          		controller.setClientTable();
	          		
					Scene scene = new Scene(root,900,600);
	    
					scene.getStylesheets().add(getClass().getResource("/graphic/myApp2.css").toExternalForm());
					primaryStage.setScene(scene);
					primaryStage.show();
					
					graphicMethods.closeStage(event);
	 	 			
	 	 		}
	 	 		else
	 	 		{
	 	 			if(object instanceof Provider)
	 	 			{
	 	 				provider=(Provider)object;
	 	 				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/graphic/view/ProviderView.fxml"));
						 Parent root = (Parent)fxmlLoader.load();
		          		
						 ProviderViewController controller = fxmlLoader.<ProviderViewController>getController();
		                 controller.setProvider(provider);
		                 
		                 int n=(int) clientInputStream.readObject();
			             ObservableList<ProviderTable> providerTable = FXCollections.observableArrayList();
			             for(int i=0;i<n;i++)
					     {
			            	 providerTable.add((ProviderTable) clientInputStream.readObject());
						 }
		          		 controller.setProviderTableData(providerTable);
		          		 controller.setProviderTable();
		          		 
		          		 Scene scene = new Scene(root,700,500);
		          		 scene.getStylesheets().add(getClass().getResource("/graphic/myApp2.css").toExternalForm());
						 primaryStage.setScene(scene);
						 primaryStage.show();
						 graphicMethods.closeStage(event);
	 	 				
	 	 			}
	 	 		}
	 	 		
	 	 	 }
	         else
 				  graphicMethods.showAlert("Login Error", confirmation);
	 	 		
	 	 	 socketConnection.close();
	 	 	 
		}
		 catch(MyException ex)
		 {
			 graphicMethods.showAlert("Login Error", ex.getMessage());
		 }
			
	 }
	 
	 @FXML
     private void createAccount(ActionEvent event) throws Exception
	 {
		 graphicMethods.loadStage("/graphic/view/ClientCreateAccountView.fxml", 400, 300);
	 }

}
