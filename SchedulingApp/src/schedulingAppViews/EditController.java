package schedulingAppViews;

import java.lang.reflect.Array;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import schedulingAppMain.MainApp;
import schedulingAppModels.Customer;
import schedulingAppUtils.DBConnection;

public class EditController implements Initializable, EventHandler<ActionEvent> {	
	@FXML
	private Label errMsg;
	@FXML
	private Button updateButton;
	@FXML
	private GridPane grid = new GridPane();
	@FXML
	private Label labelCustomerId;
	@FXML
	private Label labelCustomerName;
	@FXML
	private Label labelAddress;
	@FXML
	private Label labelAddress2;
	@FXML
	private Label labelCity;
	@FXML
	private Label labelPostalCode;
	@FXML
	private Label labelPhone;
	@FXML
	private Label labelCountry;
	@FXML
	private Label labelActive;
	@FXML
	private Label labelCreated;
	@FXML
	private Label labelCreatedBy;
	@FXML
	private Label labelLastUpdate;
	@FXML
	private Label labelLastUpdateBy;
	@FXML
	private TextField editName;
	@FXML
	private TextField editAddress;
	@FXML
	private TextField editAddress2;
	@FXML
	private TextField editCity;
	@FXML
	private TextField editPostalCode;
	@FXML
	private TextField editPhone;
	@FXML
	private TextField editCountry;
	@FXML
	private TextField editActive;
	private String updatedName;
	private String updatedAddress;
	private String updatedAddress2;
	private String updatedCity;
	private String updatedPostalCode;
	private String updatedPhone;
	private String updatedCountry;
	private String updatedActive;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1){
		grid.setGridLinesVisible(true);
		
		labelCustomerId = new Label();
		labelCustomerId.setText(OverviewController.targetRecord.getCCId());
		Insets i = new Insets(8);
		grid.setMargin(labelCustomerId, i);
		grid.add(labelCustomerId, 1, 0);
		
		labelCustomerName = new Label();
		labelCustomerName.setText(OverviewController.targetRecord.getCName());
		Insets j = new Insets(8);
		grid.setMargin(labelCustomerName, j);
		grid.add(labelCustomerName, 1, 1);
		
		labelAddress = new Label();
		labelAddress.setText(OverviewController.targetRecord.getCAddress());
		Insets k = new Insets(8);
		grid.setMargin(labelAddress, k);
		grid.add(labelAddress, 1, 2);
		
		labelAddress2 = new Label();
		labelAddress2.setText(OverviewController.targetRecord.getCAddress2());
		Insets l = new Insets(8);
		grid.setMargin(labelAddress2, l);
		grid.add(labelAddress2, 1, 3);
		
		labelCity = new Label();
		labelCity.setText(OverviewController.targetRecord.getCCity());
		Insets m = new Insets(8);
		grid.setMargin(labelCity, m);
		grid.add(labelCity, 1, 4);
		
		labelPostalCode = new Label();
		labelPostalCode.setText(OverviewController.targetRecord.getCPostalCode());
		Insets n = new Insets(8);
		grid.setMargin(labelPostalCode, n);
		grid.add(labelPostalCode, 1, 5);
		
		labelPhone = new Label();
		labelPhone.setText(OverviewController.targetRecord.getCPhone());
		Insets o = new Insets(8);
		grid.setMargin(labelPhone, o);
		grid.add(labelPhone, 1, 6);
		
		labelCountry = new Label();
		labelCountry.setText(OverviewController.targetRecord.getCCountry());
		Insets p = new Insets(8);
		grid.setMargin(labelCountry, p);
		grid.add(labelCountry, 1, 7);
		
		labelActive = new Label();
		labelActive.setText(OverviewController.targetRecord.getCActive());
		Insets q = new Insets(8);
		grid.setMargin(labelActive, q);
		grid.add(labelActive, 1, 8);
		
		labelCreated = new Label();
		labelCreated.setText(OverviewController.targetRecord.getCCreateDate());
		Insets r = new Insets(8);
		grid.setMargin(labelCreated, r);
		grid.add(labelCreated, 1, 9);
		
		labelCreatedBy = new Label();
		labelCreatedBy.setText(OverviewController.targetRecord.getCCreatedBy());
		Insets s = new Insets(8);
		grid.setMargin(labelCreatedBy, s);
		grid.add(labelCreatedBy, 1, 10);
		
		labelLastUpdate = new Label();
		labelLastUpdate.setText(OverviewController.targetRecord.getCLastUpdate());
		Insets t = new Insets(8);
		grid.setMargin(labelLastUpdate, t);
		grid.add(labelLastUpdate, 1, 11);
		
		labelLastUpdateBy = new Label();
		labelLastUpdateBy.setText(OverviewController.targetRecord.getCLastUpdateBy());
		Insets u = new Insets(8);
		grid.setMargin(labelLastUpdateBy, u);
		grid.add(labelLastUpdateBy, 1, 12);
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		PreparedStatement pst1;
		PreparedStatement pst2;
		ResultSet rs;
		String stmt1;
		String stmt2;
		
		if(
			editName.getText().length() == 0 &
			editAddress.getText().length() == 0 &
			editAddress2.getText().length() == 0 &
			editCity.getText().length() == 0 &
			editPostalCode.getText().length() == 0 &
			editPhone.getText().length() == 0 &
			editCountry.getText().length() == 0 &
			editActive.getText().length() == 0 
		)	
		{
			Alert noChangesMade = new Alert(AlertType.WARNING);
			noChangesMade.setContentText("No changes made.");
			noChangesMade.showAndWait();
		}
		if(editName.getText().isEmpty() != true){
			updatedName = editName.getText();
		}
		if(editAddress.getText().isEmpty() != true){
			updatedAddress = editAddress.getText();
		}
		if(editAddress2.getText().isEmpty() != true){
			updatedAddress2 = editAddress2.getText();
		}
		if(editCity.getText().isEmpty() != true){
			updatedCity = editCity.getText();
		}
		if(editPostalCode.getText().isEmpty() != true){
			updatedPostalCode = editPostalCode.getText();
		}
		if(editPhone.getText().isEmpty() != true){
			updatedPhone = editPhone.getText();
		}
		if(editCountry.getText().isEmpty() != true){
			updatedCountry = editCountry.getText();
		}
		if(editActive.getText().isEmpty() != true){
			updatedActive = editActive.getText();
		}
		
//		System.out.println(
//				"Customer Table: " +
//				updatedName + " " +
//				updatedActive + " " +
//				
//				"Address Table: " +
//				updatedAddress + " " +		
//				updatedAddress2 + " " +
//				updatedPostalCode + " " +
//				updatedPhone + " " +
//				
//				"City Table: " +
//				updatedCity + " " +
//				
//				"Country Table: " +
//				updatedCountry
//
//				);
		if(updatedName != null){
			stmt1 = "UPDATE `U03nV2`.`customer` " +
				"SET" +
				"`customer`.`customerName` = " + "'" + updatedName + "'" + "," +
				"`customer`.`lastUpdate` = now()," +
				"`customer`.`lastUpdateBy` = " + "'" +LoginController.currentUser + "' " +
				"WHERE `customerId` = " + OverviewController.targetRecord.getCCId() + ";";
			System.out.println(stmt1);
			stmt2 = "SELECT `customer`.`customerId`, " +
				    "`customer`.`customerName`," +
				   " `customer`.`addressId`," +
				    "`customer`.`active`," +
				    "`customer`.`createDate`," +
				    "`customer`.`createdBy`," +
				    "`customer`.`lastUpdate`," +
				    "`customer`.`lastUpdateBy`" +
				"FROM `U03nV2`.`customer`" +
				"WHERE `customerId` = " +  OverviewController.targetRecord.getCCId() + ";";
			try{
				pst1 = DBConnection.getConnection().prepareStatement(stmt1);
				pst2 = DBConnection.getConnection().prepareStatement(stmt2);
				rs = pst2.executeQuery();
				while(rs.next()){
					System.out.println("");
					System.out.println(rs.getString(1));
					System.out.println(rs.getString(2));
					System.out.println(rs.getString(3));
					System.out.println(rs.getString(4));
					System.out.println(rs.getString(5));
					System.out.println(rs.getString(6));
					System.out.println(rs.getString(7));
					System.out.println(rs.getString(8));
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			} 
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
	
	}
}
