package graphic.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import graphic.GraphicMethods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import validation.MyException;
import validation.GraphicValidations;


public class ClientCreateAccountViewController 
{
	@FXML
    private Label nameLabel;
	@FXML
    private Label usernameLabel;
	@FXML
    private Label password1Label;
	@FXML
    private Label password2Label;
	@FXML
    private TextField nameField;
	@FXML
    private TextField usernameField;
    @FXML
    private PasswordField password1Field;
    @FXML
    private PasswordField password2Field;
    @FXML
    private CheckBox automatic;
    
    private int isSelected;
    
    private GraphicValidations graphicValidations=new GraphicValidations();
    
    private GraphicMethods graphicMethods=new GraphicMethods();
    
    public ClientCreateAccountViewController()
    {
    	
    }
    
    public void setIsSelected(int n)
    {
    	this.isSelected=n;
    }
    
    @FXML
    private void createAccount(ActionEvent event) throws UnknownHostException, IOException, ClassNotFoundException
    {
    	
    	String username=usernameField.getText();
    	String name=nameField.getText();
    	String password1=password1Field.getText();
    	String password2=password2Field.getText();
    	if(isSelected!=1)
    	{
    		isSelected=0;
    	}
    	
    	try
    	{
    		graphicValidations.validationCreateNewAccount(username, password1, password2, name);

    		Socket socketConnection = new Socket("127.0.0.1", 7004);
			ObjectOutputStream clientOutputStream = new ObjectOutputStream(socketConnection.getOutputStream());
			ObjectInputStream clientInputStream = new ObjectInputStream(socketConnection.getInputStream());
			
    		String message=graphicMethods.createDataForServerCreateAccount(username, password1, password2, name,isSelected);
    		clientOutputStream.writeObject(message);
	    		
			String confirmation=(String) clientInputStream.readObject();
			if(confirmation.equals("succes"))
				graphicMethods.closeStage(event);
			else
				graphicMethods.showAlert("Create Account Error", confirmation);
						
			socketConnection.close();
    	}
    	catch(MyException ex)
    	{
    		graphicMethods.showAlert("Create Account Error", ex.getMessage());
    	}
    	
    }
    
    @FXML
    public void automaticPayments(ActionEvent event) 
    {
        if (automatic.isSelected()) 
        {
        	setIsSelected(1);
        }
        
    }
    
	@FXML 
	public void cancel(ActionEvent event) 
	{
		graphicMethods.closeStage(event);
	}

}
