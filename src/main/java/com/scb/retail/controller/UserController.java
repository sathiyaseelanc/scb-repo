package com.scb.retail.controller;

import java.util.List;

import javax.security.auth.login.Configuration.Parameters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.scb.retail.model.Customer;
import com.scb.retail.service.UserService;
import com.scb.retail.util.CommonUtil;


@RestController
public class UserController {

	@Autowired
	UserService service;


	@RequestMapping(method = RequestMethod.POST, value = "/user/save")
	public void save(@RequestHeader(value="ID-TOKEN") String idToken) throws Exception {
		service.saveUser(idToken);
	}

	@RequestMapping(value = "/api/restCall", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Object restCall(@RequestBody Parameters requestBody,@RequestHeader(value = "ID-TOKEN", required = true) String idToken) throws Exception {

		// idToken comes from the HTTP Header
		FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get();
		final String uid = decodedToken.getUid();

		// process the code here
		// once it is done
		return uid;

	}

	@RequestMapping(value = "/api/rest/customer-data", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	public @ResponseBody List<?> customerData() throws Exception {
		List<?> list = service.getCustomerData();
		System.out.println("getCustomerData:"+list);
		return list;

	}

	@RequestMapping(value = "/api/rest/customer-data-json", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getAllCustomerData() throws Exception {
		List<Customer> custList = (List<Customer>) service.getAllCustomerData();
		System.out.println("getAllCustomerData:"+custList);
		String json = CommonUtil.getJson(custList);
		
		ObjectMapper mapper = new ObjectMapper();
	    Object obj = mapper.readValue(json, Object.class);
	    return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
	}

}
