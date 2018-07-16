//package schedulingAppViews;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.mysql.jdbc.Statement;
//
//import javafx.application.Application;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.beans.property.StringProperty;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.Label;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.layout.HBox;
//import javafx.stage.Stage;
//import schedulingAppMain.MainApp;
//import schedulingAppModels.Customer;
//import schedulingAppUtils.DBConnection;
//import java.sql.PreparedStatement;
//
//public class SearchController {
//	@FXML
//	private MainApp mainApp;
//	@FXML
//	private TextField customerName;
//	@FXML
//	private TextField phone;
//	@FXML
//	private Button searchButton;
//	@FXML
//	private Label errorMsg;
//	
//	
//	@FXML
//	TableColumn<Customer, String> cId;
//	@FXML
//	TableColumn<Customer, String> cName;
//	@FXML
//	TableColumn<Customer, String> cAddressId;
//	@FXML
//	TableColumn<Customer, String> cActive;
//	@FXML
//	TableColumn<Customer, String> cCreateDate;
//	@FXML
//	TableColumn<Customer, String> cCreatedBy;
//	@FXML
//	TableColumn<Customer, String> cLastUpdate;
//	@FXML
//	TableColumn<Customer, String> cLastUpdateBy;
//	
//	
//	
//	@FXML
//	private TableView<Customer> table;
//	private DBConnection conn = null;
//	private static ResultSet rs;
//	
//	public void setMainApp(MainApp mainApp) {
//		this.mainApp = mainApp;	
//	}
//	
//	public void searchFired(){
//		ArrayList<String> customerArr = new ArrayList();
//		ObservableList<Customer> ol = FXCollections.observableArrayList();
//
////		String searchCustomerName = "SELECT `customer`.`customerId`,`customer`.`customerName`,`customer`.`addressId`,`customer`.`active`,`customer`.`createDate`,"+
////			"`customer`.`createdBy`,`customer`.`lastUpdate`,`customer`.`lastUpdateBy`"+
//		String searchCustomerName = "SELECT * " +
//			"FROM `U03nV2`.`customer`"+
//			"WHERE customerName = " + "'" + customerName.getText() + "'" + ";";
//		try{
//			PreparedStatement pst = DBConnection.getConnection().prepareStatement(searchCustomerName);
//			rs = pst.executeQuery();
//			while(rs.next()){
////				customerArr.add(rs.getString(1));
////				customerArr.add(rs.getString(2));
////				customerArr.add(rs.getString(3));
////				customerArr.add(rs.getString(4));
////				customerArr.add(rs.getString(5));
////				customerArr.add(rs.getString(6));
////				customerArr.add(rs.getString(7));
////				customerArr.add(rs.getString(8));
//				
//				//Variables of the Customer Class to be placeholders for searched customer
//				String srCustomerId = rs.getString(1);
//				String srCustomerName = rs.getString(2);
//				String srAddressId = rs.getString(3);
//				String srActive = rs.getString(4);
//				String srCreateDate = rs.getString(5);
//				String srCreatedBy = rs.getString(6);
//				String srLastUpdate = rs.getString(7);
//				String srLastUpdateBy = rs.getString(8);
//				
//				
//				// Creating Customer object to from result set
////				Customer searchResult = new Customer(srCustomerId,srCustomerName,srAddressId,srActive,srCreateDate,srCreatedBy,srLastUpdate,srLastUpdateBy);
//				
//				// Add seached customer to ObservableList
////				ol.add(searchResult);
//				
//				// Create TableColumns for display
//				cId = new TableColumn<>("customerId");
//				cId.setMinWidth(10);
//				cId.setCellValueFactory(new PropertyValueFactory<>("active"));
//				
//				cName = new TableColumn<>("customerName");
//				cName.setMinWidth(40);
//				cName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
//				
//				cAddressId = new TableColumn<>("addressId");
//				cAddressId.setMinWidth(10);
//				cAddressId.setCellValueFactory(new PropertyValueFactory<>("addressId"));
//				
//				cActive = new TableColumn<>("active");
//				cActive.setMinWidth(10);
//				cActive.setCellValueFactory(new PropertyValueFactory<>("active"));
//				
//				cCreateDate = new TableColumn<>("createDate");
//				cCreateDate.setMinWidth(10);
//				cCreateDate.setCellValueFactory(new PropertyValueFactory<>("createDate"));
//				
//				cCreatedBy = new TableColumn<>("createdBy");
//				cCreatedBy.setMinWidth(10);
//				cCreatedBy.setCellValueFactory(new PropertyValueFactory<>("createdBy"));
//				
//				cLastUpdate = new TableColumn<>("lastUpdate");
//				cLastUpdate.setMinWidth(10);
//				cLastUpdate.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
//				
//				cLastUpdateBy = new TableColumn<>("lastUpdateBy");
//				cLastUpdateBy.setMinWidth(10);
//				cLastUpdateBy.setCellValueFactory(new PropertyValueFactory<>("lastUpdateBy"));
//				
//				table = new TableView<>();
//				table.setItems(ol);
//				table.getColumns().addAll(cId,cName,cAddressId,cActive,cCreateDate,cCreatedBy,cLastUpdate,cLastUpdateBy);
//				
////				Customer displayCust = new Customer(rs.getString(1),rs.getString(2));
////				System.out.println(displayCust.toString());
////				customerList.add(current);
////				srCustomerId.setText("???");
////				srCustomerName.setText(rs.getString("customerName"));
////				srAddressId.setText(rs.getString("addressId"));
////				srActive.setText(rs.getString("active"));
////				srCreateDate.setText(rs.getString("createDate"));
////				srCreatedBy.setText(rs.getString("createdBy"));
////				srLastUpdate.setText(rs.getString("lastUpdate"));
////				srLastUpdateBy.setText(rs.getString("lastUpdateBy"));
//				//Testing output in console
////				System.out.println(rs.getString("customerName"));
////				System.out.println(srCustomerId);
////				System.out.println(srCustomerName);
////				System.out.println(srAddressId);
////				System.out.println(srActive);
////				System.out.println(srCreateDate);
////				System.out.println(srCreatedBy);
////				System.out.println(srLastUpdate);
////				System.out.println(srLastUpdateBy);
////				buildData();
//				
////				try{
////					Parent parent = FXMLLoader.load(getClass().getResource("/schedulingAppViews/OverviewLayout.fxml"));
////					Stage stage = new Stage();
////					Scene scene = new Scene(parent);
////					stage.setScene(scene);
////					stage.setTitle("Customer Overview");
////					stage.show();
////					System.out.println("LI/PW correct");	
////					buildData();
////				}
////				catch(Exception e){
////					e.printStackTrace();
////				}
//			}
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
//		System.out.println("Search Fired");
//	}
//	
//	public void buildData(){
////		try {
//			//trying to use getter and change Label in Overview...not working
//			
////			OverviewController.getoActive().setText(rs.getString("active"));
////			OverviewController.getoAddressId().setText(rs.getString("addressId"));
////			OverviewController.getoCreateDate().setText(rs.getString("createDate"));
////			OverviewController.getoCreatedBy().setText(rs.getString("createdBy"));
////			OverviewController.getoCustomerId().setText(rs.getString("customerId"));
////			OverviewController.getoCustomerName().setText(rs.getString("customerName"));
////			OverviewController.getoLastUpdate().setText(rs.getString("lastUpdate"));
////			OverviewController.getoLastUpdateBy().setText(rs.getString("lastUpdateBy"));
//			
//			//changed visibility of "o" variables to see if I can change the Labels
////			OverviewController.oActive.setText(rs.getString("active"));
////			OverviewController.oAddressId.setText(rs.getString("addressId"));
////			OverviewController.oCreateDate.setText(rs.getString("createDate"));
////			OverviewController.oCreatedBy.setText(rs.getString("createdBy"));
////			OverviewController.oCustomerId.setText(rs.getString("customerId"));
////			OverviewController.oCustomerName.setText(rs.getString("customerName"));
////			OverviewController.oLastUpdate.setText(rs.getString("lastUpdate"));
////			OverviewController.oLastUpdateBy.setText(rs.getString("lastUpdateBy"));
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
//	}
////	public ObservableList<Customer> buildData(){
////		customerData = FXCollections.observableArrayList();
////		try{
////			conn = new DBConnection();
////			conn.getConnection();
////			String selectCustomer = "SELECT * FROM `U03nV2`.`customer` WHERE customerName = '" + customerName.getText() + "';";
////			PreparedStatement pst = DBConnection.getConnection().prepareStatement("SELECT * FROM `U03nV2`.`customer` WHERE customerName = '" + customerName.getText() + "';");
////			PreparedStatement pst = DBConnection.getConnection().prepareStatement("SELECT * FROM `U03nV2`.`customer` WHERE customerName = 'Bob Jones';");
////			ResultSet rs = pst.executeQuery();
////			customerData.add(e))
////		}
////		catch(Exception e){
////			e.printStackTrace();
////		}	
////	}
//}
//
//
//
//
