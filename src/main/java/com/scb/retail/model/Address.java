package com.scb.retail.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @JsonProperty("type")
    private String id;
    
    @JsonProperty("addr-line1")
    private String addressLine1;
    
    @JsonProperty("addr-line2")
    private String addressLine2;
    
    @JsonProperty("addr-line3")
    private String addressLine3;
    
    @JsonProperty("addr-line4")
    private String addressLine4;
    
    @JsonProperty("city")
    private String city;
    
    @JsonProperty("state")
    private String state;
    
    public String getAddressLine3() {
		return addressLine3;
	}
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}
	public String getAddressLine4() {
		return addressLine4;
	}
	public void setAddressLine4(String addressLine4) {
		this.addressLine4 = addressLine4;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@JsonProperty("country-code")
    private String country;
    
    @JsonProperty("zipcode")
    private String postalCode;
    
	/**
	 * @param id
	 * @param addressLine1
	 * @param addressLine2
	 * @param city
	 * @param country
	 * @param postalCode
	 */
	public Address(String id, String addressLine1, String addressLine2, String city, String country,
			String postalCode) {
		super();
		this.id = id;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.country = country;
		this.postalCode = postalCode;
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
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}
	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}
	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}
	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", addressLine3=" + addressLine3 + ", addressLine4=" + addressLine4 + ", city=" + city + ", state="
				+ state + ", country=" + country + ", postalCode=" + postalCode + "]";
	} 
}
