package schedulingAppViews;


import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import schedulingAppUtils.DBConnection;

public class EnterNewController {

	@FXML
	private TextField customerName;
	@FXML
	private TextField address;
	@FXML
	private TextField address2;
	@FXML
	private TextField city;
	@FXML
	private TextField postalCode;
	@FXML
	private TextField country;
	@FXML
	private TextField phone;
	@FXML
	private Label errMsg;
	@FXML
	private Button submitButton;
	private int countryId;
	private int cityId;
	private int addressId;
	private int customerId;
	private Alert incompleEntryAlert;
	private Alert completeAlert;
	
	public void submitFired(){
		if(
				customerName.getText().isEmpty() == false &
				address.getText().isEmpty() == false &
				postalCode.getText().isEmpty() == false &
				phone.getText().isEmpty() == false &
				city.getText().isEmpty() == false &
				country.getText().isEmpty() == false
		)
			{
			countryCheck(country.getText());
			cityCheck(city.getText());
			addressCheck(address.getText());
			customerCheck(customerName.getText());
			
			completeAlert = new Alert(AlertType.INFORMATION);
			completeAlert.setHeaderText("Form Complete");
			completeAlert.setContentText("Success! " +customerName.getText() + " was entered in the DataBase");
			completeAlert.showAndWait();
	
			}
		
		else{
			System.out.println(customerName.getText().isEmpty());
			incompleEntryAlert = new Alert(AlertType.INFORMATION);
			incompleEntryAlert.setHeaderText("Form Incomplete");
			incompleEntryAlert.setContentText("Please complete the Required Fields");
			incompleEntryAlert.showAndWait();
			
			
		}
	}
		
	public void enterCustomer(){
		String insertCustomer = 
			"INSERT INTO `U03nV2`.`customer`" +
			"(`customerName`," +
			"`addressId`," +
			"`active`," +
			"`createDate`," +
			"`createdBy`," +
			"`lastUpdate`," +
			"`lastUpdateBy`)" +
			"VALUES" +
			"('" + customerName.getText() + "'," +
			addressId + "," +
			1 + "," +
			"now()," +
			"'" + LoginController.currentUser + "'," +
			"now()," +
			"'" + LoginController.currentUser + "');";
		
			try {
				PreparedStatement pst = DBConnection.getConnection().prepareStatement(insertCustomer);
				pst.execute();
				System.out.println("It worked, " + customerName.getText() + " was entered in the Customer Table!");
			} catch (ClassNotFoundException e) {
				System.out.println("Didn't work");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("Nope, nada");
				e.printStackTrace();
			}
	}
	
	public void customerCheck(String nm){
		customerId = 0;
		try{
			String customerCheck = 
					"SELECT `customer`.`customerId`" +
					"FROM `U03nV2`.`customer`" +
					"WHERE `customerName` = '" + customerName.getText() + "';";
			PreparedStatement pst = DBConnection.getConnection().prepareStatement(customerCheck);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				customerId = rs.getInt(1);
				System.out.println("The CustomerID is: " + rs.getInt(1));
			}
			
			else{
				enterCustomer();
				try{
					pst = DBConnection.getConnection().prepareStatement(customerCheck);
					rs = pst.executeQuery();
						if(rs.next()){
							customerId = rs.getInt(1);
							System.out.println("CustomerID is again: " + customerId);
						}
				}
				catch (ClassNotFoundException e) {
					System.out.println("Didn't work");
					e.printStackTrace();	
				} 
				
				catch (SQLException e) {
					System.out.println("Nope, nada");
					e.printStackTrace();
				}
				
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void enterCity(){
		String insertCity = 
			"INSERT INTO `U03nV2`.`city`" +
			"(`city`," +
			"`countryId`," +
			"`createDate`," +
			"`createdBy`," +
			"`lastUpdate`," +
			"`lastUpdateBy`)" +
			"VALUES" +
			"('" + city.getText() + "'," +
			countryId + "," +
			"now()," +
			"'" + LoginController.currentUser + "'," +
			"now()," +
			"'" + LoginController.currentUser + "');";
		
		try {
			PreparedStatement pst = DBConnection.getConnection().prepareStatement(insertCity);
			pst.execute();
			System.out.println("It worked, " + city.getText() + " was entered in the City Table!");
		} catch (ClassNotFoundException e) {
			System.out.println("Didn't work");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Nope, nada");
			e.printStackTrace();
		}
	}
	
	public void cityCheck(String cty){
		cityId = 0;
		try{
			String cityCheck = 
					"SELECT `city`.`cityId`" +
					"FROM `U03nV2`.`city`" +
					"WHERE `city` = '" + city.getText() + "';";
			PreparedStatement pst = DBConnection.getConnection().prepareStatement(cityCheck);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				cityId = rs.getInt(1);
				System.out.println("The CityID is: " + rs.getInt(1));
			}
			
			else{
				enterCity();
				try{
					pst = DBConnection.getConnection().prepareStatement(cityCheck);
					rs = pst.executeQuery();
						if(rs.next()){
							cityId = rs.getInt(1);
							System.out.println("CityID is again: " + cityId);
						}
				}
				catch (ClassNotFoundException e) {
					System.out.println("Didn't work");
					e.printStackTrace();	
				} 
				
				catch (SQLException e) {
					System.out.println("Nope, nada");
					e.printStackTrace();
				}
				
				catch(Exception e){
					e.printStackTrace();
				}
			}		
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void enterCountry(){
		String insertCountry = 
			"INSERT INTO `U03nV2`.`country`" +
			"(`country`," +
			"`createDate`," +
			"`createdBy`," +
			"`lastUpdate`," +
			"`lastUpdateBy`)" +
			"VALUES" +
			"(" + "'" + country.getText() + "'" + "," +
			"now()," +
			"'" + LoginController.currentUser + "'" + "," +
			"now()," +
			"'" + LoginController.currentUser + "'" + ")";
		
		try {
			PreparedStatement pst = DBConnection.getConnection().prepareStatement(insertCountry);
			pst.execute();
			System.out.println("It worked, " + country.getText() + " was entered in the Country Table");
		} catch (ClassNotFoundException e) {
			System.out.println("Didn't work");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Nope, nada");
			e.printStackTrace();
		}
	}
	
	public void countryCheck(String cntry){
		countryId = 0;
		try{
			String countryCheck = 
					"SELECT `country`.`countryId`" +
					"FROM `U03nV2`.`country`" +
					"WHERE `country`.`country` = '" + country.getText() + "';";
			PreparedStatement pst = DBConnection.getConnection().prepareStatement(countryCheck);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				countryId = rs.getInt(1);
				System.out.println("CountryId is: " + countryId);
			}
			else{
				enterCountry();
				try{
					pst = DBConnection.getConnection().prepareStatement(countryCheck);
					rs = pst.executeQuery(); 
					if(rs.next()){
						countryId = rs.getInt(1);
						System.out.println("CountryId is again: " + countryId);
					}
				} catch (ClassNotFoundException e) {
					System.out.println("Didn't work");
					e.printStackTrace();
				} catch (SQLException e) {
					System.out.println("Nope, nada");
					e.printStackTrace();
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void enterAddress(){
		address2.setText("''");
		String insertAddress = 
			"INSERT INTO `U03nV2`.`address`" +
			"(`address`," +
			"`address2`," +
			"`cityId`," +
			"`postalCode`," +
			"`phone`," +
			"`createDate`," +
			"`createdBy`," +
			"`lastUpdate`," +
			"`lastUpdateBy`)" +
			"VALUES" +
			"('" + address.getText() + "'," +
			address2.getText() + "," +
			cityId + "," +
			postalCode.getText() + "," +
			"'" + phone.getText() + "'," +
			"now()," +
			"'" + LoginController.currentUser + "'" + "," +
			"now()," +
			"'" + LoginController.currentUser + "'" + ");";
		
		try {
			PreparedStatement pst = DBConnection.getConnection().prepareStatement(insertAddress);
			pst.execute();
			System.out.println("It worked, " + address.getText() + " was entered in the Address DB");		
		} catch (ClassNotFoundException e) {
			System.out.println("Didn't work");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Nope, nada");
			e.printStackTrace();
		}finally{
			if(address2.getText().equals("''")){;
			address2.setText(null);
			}
		}
	}
	
	public void addressCheck(String add){
		addressId = 0;
		try{
			String addressCheck = 
				"SELECT `address`.`addressID`" +
				"FROM `U03nV2`.`address`" +
				"WHERE `address`.address = '" + address.getText() + "';";		
			PreparedStatement pst = DBConnection.getConnection().prepareStatement(addressCheck);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				addressId = rs.getInt(1);
				System.out.println("AddressId is: " + addressId);
			}
			else{
				enterAddress();
				try{
					pst = DBConnection.getConnection().prepareStatement(addressCheck);
					rs = pst.executeQuery(); 
					if(rs.next()){
						addressId = rs.getInt(1);
						System.out.println("AddressId is again: " + addressId);
					}
				} catch (ClassNotFoundException e) {
					System.out.println("Didn't work");
					e.printStackTrace();
				} catch (SQLException e) {
					System.out.println("Nope, nada");
					e.printStackTrace();
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void enterUser(){
		String insertUser = "";
		
		try {
			PreparedStatement pst = DBConnection.getConnection().prepareStatement(insertUser);
			pst.execute();
			System.out.println("It worked, User was entered!");
		} catch (ClassNotFoundException e) {
			System.out.println("Didn't work");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Nope, nada");
			e.printStackTrace();
		}
	}
}


