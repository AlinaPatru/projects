package application.controller;

import java.io.IOException;

import org.apache.commons.math3.optim.PointValuePair;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SolutionViewController 
{
	@FXML
    private Label zLabel;
	@FXML
    private TextField x[];
	@FXML
    private TextField zTextField;
	@FXML
	private VBox xValues;
	private PointValuePair solution;
	private int nrVariables;
	private int problemType;
	
	public SolutionViewController()
    {
    	
    }
	
	public PointValuePair getSolution() {
		return solution;
	}


	public int getNrVariables() {
		return nrVariables;
	}


	public int getProblemType() {
		return problemType;
	}


	public void setSolution(PointValuePair solution) {
		this.solution = solution;
	}


	public void setNrVariables(int nrVariables) {
		this.nrVariables = nrVariables;
	}


	public void setProblemType(int problemType) {
		this.problemType = problemType;
	}


	public void init()
    {
		if(getProblemType()==0)
			zLabel.setText("zmin=");
		else if(getProblemType()==1)
			zLabel.setText("zmax=");
		double z=getSolution().getValue();
		zTextField.setText(String.valueOf(z));
		x = new TextField[getNrVariables()];
		for(int n=0; n<getNrVariables();n++) 
		{
            x[n] = new TextField(String.valueOf(getSolution().getPoint()[n]));
            x[n].setPrefWidth(84);
            xValues.getChildren().add(x[n]);
        }
    }
	@FXML
    private void newProblem(ActionEvent event)
	{
		final Node source = (Node) event.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
	    
	    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/view/MainView.fxml"));
		Parent root;
		try {
			root = fxmlLoader.load();
			Scene scene = new Scene(root,700,600);
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			Stage primaryStage=new Stage();
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
