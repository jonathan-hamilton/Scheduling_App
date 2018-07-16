package schedulingAppViews;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import schedulingAppMain.MainApp;
import schedulingAppModels.Customer;

public class EditController1 implements Initializable {
	@FXML
	private TableView <Customer> tableCustomerId;
	@FXML
	private TableColumn <Customer, String> cId;
	
	@FXML
	private TableView <Customer> tableCustomerName;
	@FXML
	private TableColumn <Customer, String> customerName;
	
	@FXML
	private TableView <Customer> tableAddress;
	@FXML
	private TableColumn <Customer, String> address;
	
	@FXML
	private TableView <Customer> tableAddress2;
	@FXML
	private TableColumn <Customer, String> address2;
	
	@FXML
	private TableView <Customer> tableCity;
	@FXML
	private TableColumn <Customer, String> city;
	
	@FXML
	private TableView <Customer> tablePostalCode;
	@FXML
	private TableColumn <Customer, String> postalCode;
	
	@FXML
	private TableView <Customer> tablePhone;
	@FXML
	private TableColumn <Customer, String> phone;
	
	@FXML
	private TableView <Customer> tableCountry;
	@FXML
	private TableColumn <Customer, String> country;
	
	@FXML
	private TableView <Customer> tableActive;
	@FXML
	private TableColumn <Customer, String> active;
	
	@FXML
	private TableView <Customer> tableCreateDate;
	@FXML
	private TableColumn <Customer, String> createDate;
	
	@FXML
	private TableView <Customer> tableCreatedBy;
	@FXML
	private TableColumn <Customer, String> createdBy;
	
	@FXML
	private TableView <Customer> tableLastUpdate;
	@FXML
	private TableColumn <Customer, String> lastUpdate;
	
	@FXML
	private TableView <Customer> tableLastUpdateBy;
	@FXML
	private TableColumn <Customer, String> lastUpdateBy;
	@FXML
	private TableView <Customer> table;
	@FXML
	private ObservableList<Customer> ol1 =FXCollections.observableArrayList();
	@FXML
	private ObservableList<Customer> ol2 =FXCollections.observableArrayList();
	@FXML
	private ObservableList<Customer> ol3 =FXCollections.observableArrayList();
	@FXML
	private ObservableList<Customer> ol4 =FXCollections.observableArrayList();
	@FXML
	private ObservableList<Customer> ol5 =FXCollections.observableArrayList();
	@FXML
	private ObservableList<Customer> ol6 =FXCollections.observableArrayList();
	@FXML
	private ObservableList<Customer> ol7 =FXCollections.observableArrayList();
	@FXML
	private ObservableList<Customer> ol8 =FXCollections.observableArrayList();
	@FXML
	private ObservableList<Customer> ol9 =FXCollections.observableArrayList();
	@FXML
	private ObservableList<Customer> ol10 =FXCollections.observableArrayList();
	@FXML
	private ObservableList<Customer> ol11 =FXCollections.observableArrayList();
	@FXML
	private ObservableList<Customer> ol12 =FXCollections.observableArrayList();
	@FXML
	private ObservableList<Customer> ol13 =FXCollections.observableArrayList();
	
	@FXML
	private Label errMsg;
	@FXML
	private Button updateButton;
	

	// how to initialize the TextFields with the information from the Overview?
	// if changes are made to the fields once they're populated, updateFired() is executed and a confirmation message appears
	// if no changes are made, message to indicate

//	public EditController(){
//		customerId = new TextField();
//		customerId.setText("You");
//	}
	
//	static{
//		customerId = new TextField(OverviewController.targetRecord.getCCId());
//	}
//	{
//		customerId = new TextField(OverviewController.targetRecord.getCCId());
//	}
//	
//	private void initialize(){
//		String customerId = OverviewController.targetRecord.getCCId();
//		String customerName = OverviewController.targetRecord.getCName();
//		String address= OverviewController.targetRecord.getCAddress();
//		String address2= OverviewController.targetRecord.getCAddress2();
//		String city= OverviewController.targetRecord.getCCity();
//		String postalCode= OverviewController.targetRecord.getCPostalCode();
//		String country= OverviewController.targetRecord.getCCountry();
//		String phone= OverviewController.targetRecord.getCPhone();
//		String active= OverviewController.targetRecord.getCActive();
//		String createDate= OverviewController.targetRecord.getCCreateDate();
//		String createdBy= OverviewController.targetRecord.getCCreatedBy();
//		String lastUpdate= OverviewController.targetRecord.getCLastUpdate();
//		String lastUpdateBy= OverviewController.targetRecord.getCLastUpdateBy();
//		
//		customerId = new TextField().getText();
//		customerName = new TextField(OverviewController.targetRecord.getCName());
//		address = new TextField(OverviewController.targetRecord.getCAddress())";
//		address2 = new TextField(OverviewController.targetRecord.getCAddress2());
//		city = new TextField(OverviewController.targetRecord.getCCity());
//		postalCode = new TextField(OverviewController.targetRecord.getCPostalCode());
//		country = new TextField(OverviewController.targetRecord.getCCountry());
//		phone = new TextField(OverviewController.targetRecord.getCPhone());
//		active = new TextField(OverviewController.targetRecord.getCActive());
//		createDate = new TextField(OverviewController.targetRecord.getCCreateDate());
//		createdBy = new TextField(OverviewController.targetRecord.getCCreatedBy());
//		lastUpdate = new TextField(OverviewController.targetRecord.getCLastUpdate());
//		lastUpdateBy = new TextField(OverviewController.targetRecord.getCLastUpdateBy());
//		
//		customerId = new TextField();
//		customerId.setText("You");
//		customerName = new TextField(OverviewController.targetRecord.getCName());
//		address = new TextField(OverviewController.targetRecord.getCAddress());
//		address2 = new TextField(OverviewController.targetRecord.getCAddress2());
//		city = new TextField(OverviewController.targetRecord.getCCity());
//		postalCode = new TextField(OverviewController.targetRecord.getCPostalCode());
//		country = new TextField(OverviewController.targetRecord.getCCountry());
//		phone = new TextField(OverviewController.targetRecord.getCPhone());
//		active = new TextField(OverviewController.targetRecord.getCActive());
//		createDate = new TextField(OverviewController.targetRecord.getCCreateDate());
//		createdBy = new TextField(OverviewController.targetRecord.getCCreatedBy());
//		lastUpdate = new TextField(OverviewController.targetRecord.getCLastUpdate());
//		lastUpdateBy = new TextField(OverviewController.targetRecord.getCLastUpdateBy());
//	}
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1){
		
	}
	
	public void updateFired(){
		System.out.println("start of initialize method");
		
		ol1.add(OverviewController.targetRecord);
		cId.setCellValueFactory(new PropertyValueFactory<>("cCId"));
		tableCustomerId.setItems(ol1);
		
		Pane header1 = (Pane)tableCustomerId.lookup("TableHeaderRow");
		if (header1 != null && header1.isVisible()){
			header1.setPrefHeight(12);
			header1.setVisible(false);
		}
		
		Pane header2 = (Pane)tableCustomerName.lookup("TableHeaderRow");
		if (header2 != null && header2.isVisible()){
			header2.setPrefHeight(12);
			header2.setVisible(false);
		}
		
		ol2.add(OverviewController.targetRecord);
		customerName.setCellValueFactory(new PropertyValueFactory<>("cName"));
		tableCustomerName.setItems(ol2);

		Pane header3 = (Pane)tableAddress.lookup("TableHeaderRow");
		if (header3 != null && header3.isVisible()){
			header3.setPrefHeight(12);
			header3.setVisible(false);
		}
		
		ol3.add(OverviewController.targetRecord);
		address.setCellValueFactory(new PropertyValueFactory<>("CAddress"));
		tableAddress.setItems(ol3);
		
		Pane header4 = (Pane)tableAddress2.lookup("TableHeaderRow");
		if (header4 != null && header4.isVisible()){
			header4.setPrefHeight(12);
			header4.setVisible(false);
		}
		
		ol4.add(OverviewController.targetRecord);
		address2.setCellValueFactory(new PropertyValueFactory<>("CAddress2"));
		tableAddress2.setItems(ol4);
		
		Pane header5 = (Pane)tableCity.lookup("TableHeaderRow");
		if (header5 != null && header5.isVisible()){
			header5.setPrefHeight(12);
			header5.setVisible(false);
		}
		
		ol5.add(OverviewController.targetRecord);
		city.setCellValueFactory(new PropertyValueFactory<>("CCity"));
		tableCity.setItems(ol5);
		
		Pane header6 = (Pane)tablePostalCode.lookup("TableHeaderRow");
		if (header6 != null && header6.isVisible()){
			header6.setPrefHeight(12);
			header6.setVisible(false);
		}
		
		ol6.add(OverviewController.targetRecord);
		postalCode.setCellValueFactory(new PropertyValueFactory<>("CPostalCode"));
		tablePostalCode.setItems(ol6);
		
		Pane header7 = (Pane)tablePhone.lookup("TableHeaderRow");
		if (header7 != null && header7.isVisible()){
			header7.setPrefHeight(12);
			header7.setVisible(false);
		}
		
		ol7.add(OverviewController.targetRecord);
		phone.setCellValueFactory(new PropertyValueFactory<>("CPhone"));
		tablePhone.setItems(ol7);
		
		Pane header8 = (Pane)tableCountry.lookup("TableHeaderRow");
		if (header8 != null && header8.isVisible()){
			header8.setPrefHeight(12);
			header8.setVisible(false);
		}
		
		ol8.add(OverviewController.targetRecord);
		country.setCellValueFactory(new PropertyValueFactory<>("CCountry"));
		tableCountry.setItems(ol8);
		
		Pane header9 = (Pane)tableActive.lookup("TableHeaderRow");
		if (header9 != null && header9.isVisible()){
			header9.setPrefHeight(12);
			header9.setVisible(false);
		}
		
		ol9.add(OverviewController.targetRecord);
		active.setCellValueFactory(new PropertyValueFactory<>("CActive"));
		tableActive.setItems(ol9);
		
		Pane header10 = (Pane)tableCreateDate.lookup("TableHeaderRow");
		if (header10 != null && header10.isVisible()){
			header10.setPrefHeight(12);
			header10.setVisible(false);
		}
		
		ol10.add(OverviewController.targetRecord);
		createDate.setCellValueFactory(new PropertyValueFactory<>("CCreateDate"));
		tableCreateDate.setItems(ol10);
		
		Pane header11 = (Pane)tableCreatedBy.lookup("TableHeaderRow");
		if (header11 != null && header11.isVisible()){
			header11.setPrefHeight(12);
			header11.setVisible(false);
		}
		
		ol11.add(OverviewController.targetRecord);
		createdBy.setCellValueFactory(new PropertyValueFactory<>("CCreatedBy"));
		tableCreatedBy.setItems(ol11);
		
		Pane header12 = (Pane)tableLastUpdate.lookup("TableHeaderRow");
		if (header12 != null && header12.isVisible()){
			header12.setPrefHeight(12);
			header12.setVisible(false);
		}
		
		ol12.add(OverviewController.targetRecord);
		lastUpdate.setCellValueFactory(new PropertyValueFactory<>("CLastUpdate"));
		tableLastUpdate.setItems(ol12);
		
		Pane header13 = (Pane)tableLastUpdateBy.lookup("TableHeaderRow");
		if (header13 != null && header13.isVisible()){
			header13.setPrefHeight(12);
			header13.setVisible(false);
		}
		
		ol13.add(OverviewController.targetRecord);
		lastUpdateBy.setCellValueFactory(new PropertyValueFactory<>("CLastUpdateBy"));
		tableLastUpdateBy.setItems(ol13);
	}
}
