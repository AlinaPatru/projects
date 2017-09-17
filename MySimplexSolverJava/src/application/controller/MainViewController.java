package application.controller;

import application.Methods;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class MainViewController 
{
	@FXML
    private TextField nrVariablesField;
	@FXML
    private TextField nrConstraintsField;
	@FXML
    private RadioButton min;
	@FXML
    private RadioButton max;
	final ToggleGroup group = new ToggleGroup();
	private int nrVariables;
	private int nrConstraints;
	private int problemType;
	private Stage primaryStage=new Stage();
	private Methods methods=new Methods();
	
	public MainViewController()
    {

    }
	
	@FXML
    private void submit(ActionEvent event)
	{
		try
		{
			nrVariables=Integer.parseInt(nrVariablesField.getText());
			nrConstraints=Integer.parseInt(nrConstraintsField.getText());
			if(nrVariables>0 && nrConstraints>0)
			{
				if(min.isSelected())
				{
					problemType=0;
				}
			    else if(max.isSelected()) 
			    {
			    	problemType=1;
			    }
				
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/view/ConstraintsView.fxml"));
				Parent root;
				
				try {
					
					methods.closeStage(event);
				    
					root = (Parent)fxmlLoader.load();
					ConstraintsViewController controller = fxmlLoader.<ConstraintsViewController>getController();
					controller.setNrVariables(nrVariables);
					controller.setNrConstraints(nrConstraints);
					controller.setProblemType(problemType);
		            controller.init();
		            Scene scene = new Scene(root,700,600);
		    	    
					scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
					primaryStage.setScene(scene);
					primaryStage.show();
					
				} 
				catch (IOException e) 
				{
					methods.showAlert("Loading window error", "The window couldn't be loaded");
				}
				
			}
			else
				methods.showAlert("Data entered error", "The numbers of variables and constraints must be greater than 0");
		}
		catch (NumberFormatException e) 
		{
			methods.showAlert("Data entered error", "Check if data is corectly entered");
		}
    }

}
