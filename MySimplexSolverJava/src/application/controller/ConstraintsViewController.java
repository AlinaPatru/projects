package application.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.math3.exception.TooManyIterationsException;
import org.apache.commons.math3.optim.MaxIter;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.LinearConstraintSet;
import org.apache.commons.math3.optim.linear.LinearObjectiveFunction;
import org.apache.commons.math3.optim.linear.NoFeasibleSolutionException;
import org.apache.commons.math3.optim.linear.NonNegativeConstraint;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.linear.SimplexSolver;
import org.apache.commons.math3.optim.linear.UnboundedSolutionException;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import application.Methods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConstraintsViewController 
{
	@FXML
    private TextField objectiveFunctionCoefficients[] ;
	@FXML
    private TextField constraintCoefficients[];
	@FXML
    private TextField constant;
	@FXML
	private TilePane objectiveFunctionPane;
	@FXML
	private TilePane constraintPane[];
	@FXML
	private VBox constraintsPane;
	@FXML
    private RadioButton less;
	@FXML
    private RadioButton greater;
	@FXML
    private RadioButton equal;
	private ToggleGroup groupEqualties[] ;
	final ToggleGroup group = new ToggleGroup();
	private int nrConstraints;
	private Stage primaryStage=new Stage();
	private PointValuePair solution;
	private int nrVariables;
	private int problemType;
	private Methods methods=new Methods();
	
	public ConstraintsViewController()
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
	
	public int getNrConstraints() {
		return nrConstraints;
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
	
	public void setNrConstraints(int nrConstraints) {
		this.nrConstraints = nrConstraints;
	}
	
	public void init()
	{
		int nrVariab=getNrVariables();
		int nrConstr=getNrConstraints();
		
		objectiveFunctionPane.setHgap(5);
		objectiveFunctionCoefficients = new TextField[nrVariab];
		for(int i=0; i<nrVariab;i++) 
		{
            objectiveFunctionCoefficients[i] = new TextField("");
            objectiveFunctionCoefficients[i].setPrefWidth(55);
            objectiveFunctionPane.getChildren().add(objectiveFunctionCoefficients[i]);
        }
	
		constraintCoefficients = new TextField[nrVariab];
		groupEqualties = new ToggleGroup[nrConstr];
		constraintPane=new TilePane[nrConstr];
		
		for(int i=0; i<nrConstr;i++) 
		{
			groupEqualties[i] = new ToggleGroup();
			constraintPane[i]=new TilePane();
			constraintPane[i].setHgap(5);
			
			for(int j=0; j<nrVariab;j++) 
			{
				constraintCoefficients[j] = new TextField("");
				constraintCoefficients[j].setPrefWidth(55);
	            constraintPane[i].getChildren().add(constraintCoefficients[j]);
	        }
			
			less= new RadioButton("<=");
    		less.setToggleGroup(groupEqualties[i]);
    		less.setSelected(true);
    		greater= new RadioButton(">=");
    		greater.setToggleGroup(groupEqualties[i]);
    		equal= new RadioButton("=");
    		equal.setToggleGroup(groupEqualties[i]);
    		
    		constraintPane[i].getChildren().add(less);
    		constraintPane[i].getChildren().add(greater);
    		constraintPane[i].getChildren().add(equal);
    		
    		constant = new TextField("");
    		constant.setPrefWidth(55);
    		
    		constraintPane[i].getChildren().add(constant);
			constraintsPane.getChildren().add(constraintPane[i]);
        }
	}
	
	@FXML
    private void solve(ActionEvent event)
	{
		int nrVariab=getNrVariables();
		int nrConstr=getNrConstraints();
		double objectiveFunctionCoef[]=new double[nrVariab];
		double constraintsCoef[]=new double[nrVariab];
		Collection<LinearConstraint> constraints = new ArrayList<LinearConstraint>();
		try
		{
			for(int i=0;i<nrConstr;i++)
			{
				for(int j=0;j<nrVariab;j++)
				{
					constraintsCoef[j]=Double.parseDouble(((TextField) constraintPane[i].getChildren().get(j)).getText());
					objectiveFunctionCoef[j]=Double.parseDouble(objectiveFunctionCoefficients[j].getText());
				}
				if(((RadioButton) constraintPane[i].getChildren().get(nrVariables)).isSelected())
				{
					constraints.add(new LinearConstraint(constraintsCoef, Relationship.LEQ,Double.parseDouble(((TextField) constraintPane[i].getChildren().get(nrVariables+3)).getText())));
				}
			    else if(((RadioButton) constraintPane[i].getChildren().get(nrVariables+1)).isSelected()) 
			    {
			    	constraints.add(new LinearConstraint(constraintsCoef, Relationship.GEQ, Double.parseDouble(((TextField) constraintPane[i].getChildren().get(nrVariables+3)).getText())));
			    }
			    else if(((RadioButton) constraintPane[i].getChildren().get(nrVariables+2)).isSelected()) 
			    {
			    	constraints.add(new LinearConstraint(constraintsCoef, Relationship.EQ, Double.parseDouble(((TextField) constraintPane[i].getChildren().get(nrVariables+3)).getText())));
			    }
			}
			
			LinearObjectiveFunction f = new LinearObjectiveFunction(objectiveFunctionCoef, 0);
			
			PointValuePair solution = null;
			if(getProblemType()==0)
			{
				solution = new SimplexSolver().optimize(new MaxIter(100),f, new LinearConstraintSet(constraints), GoalType.MINIMIZE, new NonNegativeConstraint(true));
			}
		    else if(getProblemType()==1) 
		    {
		    	solution = new SimplexSolver().optimize(new MaxIter(100),f, new LinearConstraintSet(constraints), GoalType.MAXIMIZE, new NonNegativeConstraint(true));
		    }
		    
			if (solution != null) 
			{
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/view/SolutionView.fxml"));
				Parent root;
				try 
				{
					
					methods.closeStage(event);
					
					root = (Parent)fxmlLoader.load();
					SolutionViewController controller = fxmlLoader.<SolutionViewController>getController();
					controller.setNrVariables(nrVariables);
					controller.setProblemType(getProblemType());
					controller.setSolution(solution);
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
		}
		catch (NumberFormatException e) 
		{
			methods.showAlert("Data entered error", "Check if data is corectly entered");
		}
		catch (UnboundedSolutionException e) 
		{
			methods.showAlert("Unbounded solution", "The solution of the problem is unbounded");
		}
		catch (NoFeasibleSolutionException e) 
		{
			methods.showAlert("No solution", "The problem has no solution");
		}
		catch (TooManyIterationsException e) 
		{
			methods.showAlert("Cycling", "Indefinite cycling");
		}
		
	    
    }
	
	@FXML
    private void back(ActionEvent event)
    {
		methods.closeStage(event);
	    
	    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/view/MainView.fxml"));
		Parent root;
		try {
			root = fxmlLoader.load();
			Scene scene = new Scene(root,700,600);
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			Stage primaryStage=new Stage();
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} 
		catch (IOException e) 
		{
			methods.showAlert("Loading window error", "The window couldn't be loaded");
		}
    }
	
}
