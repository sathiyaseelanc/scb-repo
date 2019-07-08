package com.scb.retail.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scb.retail.model.Address;
import com.scb.retail.model.Customer;
import com.scb.retail.model.CustomerJson;

public class CommonUtil {

	public static String getJson(List<Customer> custList) {
		
		CustomerJson c1 = null;
		List<Address> addressList = null;
		List<CustomerJson> custJsonList =  new ArrayList<>();;
		String json = null;
		for(Customer cust: custList) {
			addressList = new ArrayList<>();
			
			c1=new CustomerJson();
			c1.setId(cust.getId());
			c1.setFirstName(cust.getFirstName());
			c1.setLastName(cust.getLastName());
			c1.setContactNo(cust.getContactNo());
			addressList.add(cust.getAddress());
			c1.setAddress(addressList);
			custJsonList.add(c1);
		}
		
		Map<Integer, CustomerJson> map = new HashMap<>();
		int i =0;
		for(CustomerJson custJson : custJsonList) {
			map.put(i++, custJson);
		}

		ObjectMapper mapper = new ObjectMapper();
		try {
			 json = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

}
