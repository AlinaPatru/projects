package graphic.controller;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import graphic.GraphicMethods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Client;
import validation.MyException;
import validation.GraphicValidations;


public class ClientChangeDataViewController 
{
	@FXML
    private Label newNameLabel;
	@FXML
    private Label oldPasswordLabel;
	@FXML
    private Label newPassword1Label;
	@FXML
    private Label newPassword2Label;
	@FXML
    private TextField newNameField;
	@FXML
    private PasswordField oldPasswordField;
    @FXML
    private PasswordField newPassword1Field;
    @FXML
    private PasswordField newPassword2Field;
    
    private GraphicValidations graphicValidations=new GraphicValidations();
	
	private GraphicMethods graphicMethods=new GraphicMethods();
    
    public ClientChangeDataViewController()
    {
    	
    }
    
    @FXML
    private void oK(ActionEvent event) throws IOException 
    {
        String newName=newNameField.getText();
        String oldPassword=oldPasswordField.getText();
        String newPassword1=newPassword1Field.getText();
        String newPassword2=newPassword2Field.getText();
        
        try
        {
        	final Node source = (Node) event.getSource();
    	    final Stage stage = (Stage) source.getScene().getWindow();
    	    Client client =new Client();
    	    client=(Client) stage.getUserData();
    	    
    	    graphicValidations.validationChangeClientData(client, newName, oldPassword, newPassword1, newPassword2);
    	    
    	    Socket socketConnection = new Socket("127.0.0.1", 7004);
			ObjectOutputStream clientOutputStream = new ObjectOutputStream(socketConnection.getOutputStream());
    	    
			String message = graphicMethods.createDataForServerChangeClientData(client, newName, oldPassword, newPassword1, newPassword2);
			
			clientOutputStream.writeObject(message);
	        
			socketConnection.close();
        	stage.close();
        	
        	
        }
        catch(MyException ex)
        {
        	graphicMethods.showAlert("Change Data Error", ex.getMessage());
        }
	    
    }    
    
    @FXML
    private void cancel(ActionEvent event) 
    {
    	graphicMethods.closeStage(event);
    }

}
