package schedulingAppModels;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;

public class Customer {
	
	private String customerId;
	private String Name;
	private String addressId;
	private String active;
	private String createDate; 
	private String createdBy;
	private String lastUpdate; 
	private String lastUpdateBy;
	
	private String address;
	private String address2;
	private String postalCode;
	private String phone;
	
	private String city;
	
	private String country;

	public Customer(
			String cId, 
			String cName, 
			String cAddr, 
			String cAddr2, 
			String cCty, 
			String cPCode, 
			String cPhone,
			String cCntry, 
			String cActive, 
			String cCreateDate, 
			String cCreatedBy,
			String cLastUpdate,
			String cLastUpdateBy
			){
		this.customerId = cId;
		this.Name = cName;
		this.address = cAddr;
		this.address2 = cAddr2;
		this.setCCity(cCty);
		this.postalCode = cPCode;
		this.phone = cPhone;
		this.country = cCntry;
		this.active = cActive;
		this.createDate = cCreateDate;
		this.createdBy = cCreatedBy;
		this.lastUpdate = cLastUpdate;
		this.lastUpdateBy = cLastUpdateBy;
		
		
	}
	
	public String getCAddress() {
		return address;
	}

	public void setCAddress(String address) {
		this.address = address;
	}

	public String getCPhone() {
		return phone;
	}

	public void setCPhone(String phone) {
		this.phone = phone;
	}

	public String getCCreatedBy() {
		return createdBy;
	}

	public void setCCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getCName() {
		return Name;
	}

	public void setCName(String cName) {
		this.Name = cName;
	}

	public String getCCreateDate() {
		return createDate;
	}

	public void setCCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCActive() {
		return active;
	}

	public void setCActive(String active) {
		this.active = active;
	}

	public String getCAddressId() {
		return addressId;
	}

	public void setCAddressId(String addressId) {
		this.addressId = addressId;
	}
	
	public String getCLastUpdate() {
		return lastUpdate;
	}

	public void setCLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getCLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setCLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}
	
	public String getCCId() {
		return customerId;
	}

	public void setCCId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getCAddress2() {
		return address2;
	}

	public void setCAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCPostalCode() {
		return postalCode;
	}

	public void setCPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCCountry() {
		return country;
	}

	public void setCCountry(String country) {
		this.country = country;
	}

	public String getCCity() {
		return city;
	}

	public void setCCity(String city) {
		this.city = city;
	}
}
