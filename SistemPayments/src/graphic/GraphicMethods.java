package graphic;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Client;

public class GraphicMethods 
{
	public void closeStage(ActionEvent event)
	{
		final Node source = (Node) event.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
	}
	
	public void showAlert(String headerText,String message)
	{
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText(headerText);
		alert.setContentText(message);
		alert.showAndWait();
	}
	
	public void loadStage(String resource,int width,int height) throws Exception
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resource));
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root,width,height);
		scene.getStylesheets().add(getClass().getResource("/graphic/myApp2.css").toExternalForm());
		Stage primaryStage=new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public String createDataForServerCreateAccount(String username , String password1 , String password2, String name,int state)
	{	
		StringBuilder sb = new StringBuilder("createAccount" +"^");
		sb.append(username);
		sb.append("^" + password1);
		sb.append("^" + password2);
		sb.append("^" + name);
		sb.append("^" + state);
		
		return sb.toString();
	}
	
	public String createDataForServerLogin(String username, String password)
	{
		StringBuilder sb = new StringBuilder("login" +"^");
		sb.append(username);
		sb.append("^" + password);
		
		return sb.toString();
	}
	
	public String createDataForServerChangeClientData(Client c,String name, String oldPassword, String newPassword1, String newPassword2)
	{	
		StringBuilder sb = new StringBuilder("changeData" +"^");
		sb.append(c.getIdClient());
		sb.append("^" + name);
		sb.append("^" + newPassword1);
		
		return sb.toString();
	}
	
	public String createDataForServerAddToDeposit(Client c,String sum)
	{	
		StringBuilder sb = new StringBuilder("addToDeposit" +"^");
		sb.append(c.getIdClient());
		sb.append("^" + sum);
		
		return sb.toString();
	}
	
	public String createDataForServerDeleteFromDeposit(int idClient,double sum,int idBill)
	{	
		StringBuilder sb = new StringBuilder("deleteFromDeposit" +"^");
		sb.append(idClient);
		sb.append("^" + sum);
		sb.append("^" + idBill);
		return sb.toString();
	}
	
	public String createDataForServerDeleteBill(int idBill,double sum)
	{	
		StringBuilder sb = new StringBuilder("deleteBill" +"^");
		sb.append(idBill);
		sb.append("^" + sum);
		
		return sb.toString();
	}
	
	public String createDataForServerSubscribe(int idClient)
	{	
		StringBuilder sb = new StringBuilder("createProviderTableSubscribe" +"^");
		sb.append(idClient);
		
		return sb.toString();
	}
	
	public String createDataForServerUnsubscribe(int idClient)
	{	
		StringBuilder sb = new StringBuilder("createProviderTableUnsubscribe" +"^");
		sb.append(idClient);
		
		return sb.toString();
	}
	
	public String createDataForServerCreateFinesTable(int idClient)
	{	
		StringBuilder sb = new StringBuilder("createFinesTable" +"^");
		sb.append(idClient);
		
		return sb.toString();
	}


}
