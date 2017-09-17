package graphic.controller;

import graphic.GraphicMethods;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Provider;
import model.ProviderTable;

public class ProviderViewController 
{
	@FXML
    private TableView<ProviderTable> billTable=new TableView<ProviderTable>();
	@FXML
    private TableColumn<ProviderTable,Integer> idBillColumn;
    @FXML
    private TableColumn<ProviderTable, String> clientNameColumn;
    @FXML
    private TableColumn<ProviderTable, Double> priceColumn;
    @FXML
    private TableColumn<ProviderTable, String> startDateColumn;
    @FXML
    private TableColumn<ProviderTable,String> limitDateColumn;
    
	@FXML
    private Label depositLabel;
	@FXML
    private Label welcomeLabel;
    @FXML
    private TextField depositField;
    
    private GraphicMethods graphicMethods=new GraphicMethods();
    
    private Provider provider =new Provider();

    private ObservableList<ProviderTable> providerTable = FXCollections.observableArrayList();

    public ProviderViewController()
    {
    	
    }
    
    public void setProviderTableData(ObservableList<ProviderTable> allBills) 
    {
		this.providerTable=allBills;
	}
    
    public void setProvider(Provider provider) 
    {
		this.provider=provider;
	}
    
    public void setProviderTable()
    {
    	depositField.setText(provider.getDeposit()+"");
    	welcomeLabel.setText("Welcome "+provider.getName()+"!");
    	
    	idBillColumn.setCellValueFactory(new PropertyValueFactory<>("idBill"));
    	clientNameColumn.setCellValueFactory(new PropertyValueFactory<>("clientName"));
		startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		limitDateColumn.setCellValueFactory(new PropertyValueFactory<>("limitDate"));
		
		billTable.setItems(providerTable);
    }
	
	@FXML
    private void logout(ActionEvent event)throws Exception 
	{
		graphicMethods.loadStage("/graphic/view/LoginView.fxml", 700, 500);
		graphicMethods.closeStage(event);
    }

}
