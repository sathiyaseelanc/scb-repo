package com.scb.retail.service;

import java.util.List;

public interface UserService {

	public void saveUser(String idToken) throws Exception;
	
	public List<?> getCustomerData() throws Exception;

	List<?> getAllCustomerData() throws Exception;

}
