package schedulingAppViews;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.stage.Stage;
import schedulingAppMain.MainApp;
import schedulingAppModels.Address;
import schedulingAppModels.Customer;
import schedulingAppUtils.DBConnection;

public class OverviewController{ 
	@FXML
	private MainApp mainApp;
	@FXML
	private Button enterNewButton;
	@FXML
	private Button searchButton;
	@FXML
	private Button editButton;
	@FXML
	private Button setApptButton;
	@FXML
	private Button reportsButton;
	
	@FXML
	private Label errMsg = new Label("");
	
	@FXML
	TextField searchByName;
	@FXML
	TextField searchByPhone;
	
	@FXML
	TableView<Customer> table;
	@FXML
	TableColumn<Customer, String> cId;
	@FXML
	TableColumn<Customer, String> cName;
	
	public TableColumn<Customer, String> getCName() {
		return cName;
	}

	public void setCName(TableColumn<Customer, String> cName) {
		this.cName = cName;
	}

	@FXML
	TableColumn<Customer, String> cAddressId;
	@FXML
	TableColumn<Customer, String> cActive;
	@FXML
	TableColumn<Customer, String> cCreateDate;
	@FXML
	TableColumn<Customer, String> cCreatedBy;
	@FXML
	TableColumn<Customer, String> cLastUpdate;
	@FXML
	TableColumn<Customer, String> cLastUpdateBy;
	@FXML
	TableColumn<Address, String> cPhone;
	@FXML
	TableColumn<Address, String> cAddress;
	@FXML
	TableColumn<Address, String> cCity;
	@FXML
	ObservableList<Customer> ol = FXCollections.observableArrayList();
	@FXML
	static	Customer targetRecord;
	@FXML
	public OverviewController getOverviewController(){
		return null;
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		
	}
	
	@FXML
	public void enterNewFired(){
		try{
			Parent parent = FXMLLoader.load(getClass().getResource("/schedulingAppViews/EnterNewLayout.fxml"));
			Stage stage = new Stage();
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.setTitle("Enter New Customer");
			stage.show();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@FXML
	public void searchFired(){
		String searchStmt = null;
		errMsg.setText("");
		if(searchByName.getText().isEmpty() == false && searchByPhone.getText().isEmpty() == true){
			searchStmt =
				"SELECT " +
				"`customer`.`customerId`," +
				"`customer`.`customerName`," +
				"`address`.`address`," +
			    "`address`.`address2`," +
				"`city`.`city`," +
			    "`address`.`postalCode`," +
				"`address`.`phone`," +
			    "`country`.`country`," +
				"`customer`.`active`," +
			    "`customer`.`createDate`," +
			    "`customer`.`createdBy`," +
			    "`customer`.`lastUpdate`," +
			    "`customer`.`lastUpdateBy`" +
			   
				"FROM `U03nV2`.`address`,`U03nV2`.`city`, `U03nV2`.`country`,`U03nV2`.`customer`" +
				"WHERE `U03nV2`.`address`.cityId = `U03nV2`.`city`.cityId " +
				"AND `U03nV2`.`country`.countryId = `U03nV2`.`city`.countryId " +
				"AND `U03nV2`.`customer`.addressId = `U03nV2`.`address`.addressID " +
				"AND `U03nV2`.`customer`.`customerName` = '" + searchByName.getText() + "';";
			
				
//					= "SELECT `customer`.`customerId`,"+
//					"`customer`.`customerName`,"+
//				    "`customer`.`addressId`,"+
//				    "`customer`.`active`,"+
//				    "`customer`.`createDate`,"+
//				    "`customer`.`createdBy`,"+
//				    "`customer`.`lastUpdate`,"+
//				    "`customer`.`lastUpdateBy`,"+
//					"`address`.`address`,"+
//				    "`address`.`phone`"+
//				"FROM `U03nV2`.`customer`"+
//				"JOIN `U03nV2`.`address`"+
//				"ON `customer`.`addressId` = `address`.`addressID`"+
//				"WHERE `customer`.`customerName` = '" + searchByName.getText() + "';";

				System.out.println("Search by Name fired");
		}

		else if(searchByPhone.getText().isEmpty() == false && searchByName.getText().isEmpty() == true){
			searchStmt =
					"SELECT " +
							"`customer`.`customerId`," +
							"`customer`.`customerName`," +
							"`address`.`address`," +
						    "`address`.`address2`," +
							"`city`.`city`," +
						    "`address`.`postalCode`," +
							"`address`.`phone`," +
						    "`country`.`country`," +
							"`customer`.`active`," +
						    "`customer`.`createDate`," +
						    "`customer`.`createdBy`," +
						    "`customer`.`lastUpdate`," +
						    "`customer`.`lastUpdateBy`" +
						   
							"FROM `U03nV2`.`address`,`U03nV2`.`city`, `U03nV2`.`country`,`U03nV2`.`customer`" +
							"WHERE `U03nV2`.`address`.cityId = `U03nV2`.`city`.cityId " +
							"AND `U03nV2`.`country`.countryId = `U03nV2`.`city`.countryId " +
							"AND `U03nV2`.`customer`.addressId = `U03nV2`.`address`.addressID " +
							"AND `U03nV2`.`address`.`phone` = '" + searchByPhone.getText() + "';";
					
//				= "SELECT `customer`.`customerId`,"+
//			    "`customer`.`customerName`,"+
//			    "`customer`.`addressId`,"+
//			    "`customer`.`active`,"+
//			    "`customer`.`createDate`,"+
//			    "`customer`.`createdBy`,"+
//			    "`customer`.`lastUpdate`,"+
//			    "`customer`.`lastUpdateBy`,"+
//				"`address`.`address`,"+
//				"`address`.`phone`"+
//			"FROM `U03nV2`.`customer`"+
//			"JOIN `U03nV2`.`address`"+
//			"ON `customer`.`addressId` = `address`.`addressID`"+
//			"WHERE `address`.`phone` = '" + searchByPhone.getText() + "';";
			System.out.println("Search by Phone fired");
		}
		
		else if(searchByPhone.getText().isEmpty() == false && searchByName.getText().isEmpty() == false){
			errMsg.setText("INVALID ENTRY");
		}
		
		else{
			errMsg.setText("INVALID ENTRY");
		}
		
		try{
			if(searchStmt != null){
			SQLQuery(searchStmt);
			}
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void SQLQuery(String stmt)throws SQLException {
		try{
			PreparedStatement pst = DBConnection.getConnection().prepareStatement(stmt);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				//Variables of the Customer Class to be placeholders for searched customer
				String srCustomerId = rs.getString(1);
				String srCustomerName = rs.getString(2);
				String srAddress = rs.getString(3);
				String sraddress2 = rs.getString(4);
				String srCity = rs.getString(5);
				String srPostalCode = rs.getString(6);
				String srPhone = rs.getString(7);
				String srCountry = rs.getString(8);
				String srActive = rs.getString(9);
				String srCreateDate = rs.getString(10);
				String srCreatedBy = rs.getString(11);
				String srLastUpdate = rs.getString(12);
				String srLastUpdatedBy = rs.getString(13);
				
				
				
				 //Creating Customer object to from result set
				Customer searchResult = new Customer(
						srCustomerId,
						srCustomerName,
						srAddress,
						sraddress2,
						srCity,
						srPostalCode,
						srPhone,
						srCountry,
						srActive,
						srCreateDate,
						srCreatedBy,
						srLastUpdate,
						srLastUpdatedBy
						);
				
//				Sets the targetRecord for editing in the EditLayout
				targetRecord = searchResult;
				
				// Add to the ObservableList of Customers
				ol.add(searchResult);
				
				// set cell values of TableColumns
//				cId.setCellValueFactory(new PropertyValueFactory<>("cId"));
				cName.setCellValueFactory(new PropertyValueFactory<>("cName"));
//				cAddressId.setCellValueFactory(new PropertyValueFactory<>("cAddressId"));
//				cActive.setCellValueFactory(new PropertyValueFactory<>("cActive"));
//				cCreateDate.setCellValueFactory(new PropertyValueFactory<>("cCreateDate"));
//				cCreatedBy.setCellValueFactory(new PropertyValueFactory<>("cCreatedBy"));
//				cLastUpdate.setCellValueFactory(new PropertyValueFactory<>("cLastUpdate"));
//				cLastUpda/teBy.setCellValueFactory(new PropertyValueFactory<>("cLastUpdateBy"));
				
//				cAddress.setCellValueFactory(new PropertyValueFactory<>("cAddress"));
				cPhone.setCellValueFactory(new PropertyValueFactory<>("cPhone"));
				
				
				table.setItems(ol);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@FXML
	public void editFired(){
//		Customer cust = table.getSelectionModel().getSelectedItem();
//		if(cust.getCAddress2() != null)
//		System.out.println(
//			cust.getCCId() + " " +
//			cust.getCName() + " " +
//			cust.getCAddress() + " " +
//			cust.getCAddress2() + " " +
//			cust.getCCity() + " " +
//			cust.getCPostalCode() + " " +
//			cust.getCPhone() + " " +
//			cust.getCCountry() + " " +
//			cust.getCActive() + " " +
//			cust.getCCreateDate() + " " +
//			cust.getCCreatedBy() + " " +
//			cust.getCLastUpdate() + " " +
//			cust.getCLastUpdateBy()
//				);
//		else {
//			System.out.println(
//			cust.getCCId() + " " +
//			cust.getCName() + " " +
//			cust.getCAddress() + " " +
//			cust.getCCity() + " " +
//			cust.getCPostalCode() + " " +
//			cust.getCPhone() + " " +
//			cust.getCCountry() + " " +
//			cust.getCActive() + " " +
//			cust.getCCreateDate() + " " +
//			cust.getCCreatedBy() + " " +
//			cust.getCLastUpdate() + " " +
//			cust.getCLastUpdateBy());
//		}
	
			try{
				Parent parent = FXMLLoader.load(getClass().getResource("/schedulingAppViews/EditLayout.fxml"));
				Stage stage = new Stage();
				Scene scene = new Scene(parent);
				stage.setScene(scene);
				stage.setTitle("Edit Customer");
				stage.show();

			}
			catch(Exception e){
				e.printStackTrace();
			}
	}
	
	@FXML
	public void setAppointmentFired(){
		System.out.println("Set Appointments Fired");
	}
	
	@FXML
	public void reportsFired(){
		System.out.println("Reports Fired");
	}
}
