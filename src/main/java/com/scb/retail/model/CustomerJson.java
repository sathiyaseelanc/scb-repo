package com.scb.retail.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerJson implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @JsonIgnore
    private String id;
    
    @JsonProperty("first-name")
    private String firstName;
    
    @JsonProperty("middle-name")
    private String middleName;
    
    @JsonProperty("last-name")
    private String lastName;
    
    @JsonProperty("date-of-birth")
    private String dob="10-May-1978";
    
    @JsonProperty("mobile-number")
    private String contactNo;
    
    @JsonProperty("gender")
    private String gender="M";
    
    @JsonProperty("customer-number")
    private String customerNumber="AU10042001";
    
    @JsonProperty("country-of-birth")
    private String countryOfBirth="US";
    
    @JsonProperty("country-of-residence")
    private String countryOfResidence="SG";
    
    @JsonProperty("customer-segment")
    private String customerSegment="Retail";
    
    public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getCountryOfBirth() {
		return countryOfBirth;
	}
	public void setCountryOfBirth(String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
	}
	public String getCountryOfResidence() {
		return countryOfResidence;
	}
	public void setCountryOfResidence(String countryOfResidence) {
		this.countryOfResidence = countryOfResidence;
	}
	public String getCustomerSegment() {
		return customerSegment;
	}
	public void setCustomerSegment(String customerSegment) {
		this.customerSegment = customerSegment;
	}
	@JsonProperty("addresses")
    private List<Address> address;
    
   
	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param contactNo
	 * @param address
	 */
	public CustomerJson(String id, String firstName, String lastName, String contactNo, List<Address> address) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.address = address;
	}
	public CustomerJson() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the contactNo
	 */
	public String getContactNo() {
		return contactNo;
	}
	/**
	 * @param contactNo the contactNo to set
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	/**
	 * @return the address
	 */
	public List<Address> getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "CustomerJson [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", dob=" + dob + ", contactNo=" + contactNo + ", gender=" + gender + ", customerNumber="
				+ customerNumber + ", countryOfBirth=" + countryOfBirth + ", countryOfResidence=" + countryOfResidence
				+ ", customerSegment=" + customerSegment + ", address=" + address + "]";
	}
}
