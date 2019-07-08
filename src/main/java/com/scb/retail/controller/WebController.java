package com.scb.retail.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scb.retail.model.Address;
import com.scb.retail.model.Customer;
import com.scb.retail.repository.RedisRepository;

@Controller
@RequestMapping("/")
public class WebController {
    
    @Autowired
    private RedisRepository redisRepository;

    @RequestMapping("/")
    public String login() {
        return "login";
    }
    
    @RequestMapping("/index")
    public String index() {
        return "login";
    }
    
    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
    
    @RequestMapping("/home")
    public String home() {
        return "home";
    }
    
    @RequestMapping("/rest")
    public String rest() {
        return "rest";
    }
    
    @RequestMapping("/webservice")
    public String webservice() {
        return "webservice";
    }
    

    @RequestMapping("/keys")
    public @ResponseBody Map<Object, Object> keys() {
        return redisRepository.findAllCustomer();
    }

    @RequestMapping("/values")
    public @ResponseBody Map<String, String> findAll() {
        Map<Object, Object> aa = redisRepository.findAllCustomer();
        Map<String, String> map = new HashMap<>();
        for(Map.Entry<Object, Object> entry : aa.entrySet()){
            String key = (String) entry.getKey();
            map.put(key, aa.get(key).toString());
        }
        return map;
    }
    
    @RequestMapping("/listvalues")
    public @ResponseBody List<Customer> findAllList() {
    	List<Customer> plist = redisRepository.findAllCustomerList();
        return plist;
    }
    
    @RequestMapping("/multiget")
    public @ResponseBody List<?> findAllMultiGet() {
    	List<Customer> plist = (List<Customer>) redisRepository.findAllMultiGet();
    	Map<String,List> map = new HashMap<>();
    	List tmpList,finalList;
    	
    	for(Customer p:plist) {
    	tmpList = new ArrayList();
    	tmpList.add(p.getId());
    	tmpList.add(p.getFirstName());
    	tmpList.add(p.getLastName());
    	tmpList.add(p.getContactNo());
    	tmpList.add(p.getAddress().getId());
    	tmpList.add(p.getAddress().getAddressLine1());
    	tmpList.add(p.getAddress().getAddressLine2());
    	tmpList.add(p.getAddress().getCity());
    	tmpList.add(p.getAddress().getCountry());
    	tmpList.add(p.getAddress().getPostalCode());
    	map.put(p.getId(), tmpList);
    	}
    	
    	finalList = new ArrayList();
    	if(map.size()>0) {
    		Iterator it = map.entrySet().iterator();
    	    while (it.hasNext()) {
    	        Map.Entry pair = (Map.Entry)it.next();
    	        //System.out.println(pair.getKey() + " = " + pair.getValue());
    	        finalList.add(pair.getValue());
    	    }
    	}
    	
    	//System.out.println(finalList);
        return finalList;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> add(
        @RequestParam String key,
        @RequestParam String firstName,
        @RequestParam String lastName,
        @RequestParam String contactNo,
        @RequestParam String addressType,
        @RequestParam String addressLine1,
        @RequestParam String addressLine2,
        @RequestParam String city,
        @RequestParam String country,
        @RequestParam String postalCode
        ) {
        
    	Address address = new Address(key+"-"+addressType, addressLine1, addressLine2, city, country,postalCode);
    	Customer cust = new Customer(key, firstName,lastName,contactNo,address);
        
        redisRepository.add(cust);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<String> delete(@RequestParam String key) {
        redisRepository.delete(key);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/update")
	public ResponseEntity<String> update(
			@RequestParam String key,
	        @RequestParam String firstName,
	        @RequestParam String lastName,
	        @RequestParam String contactNo,
	        @RequestParam String addressType,
	        @RequestParam String addressLine1,
	        @RequestParam String addressLine2,
	        @RequestParam String city,
	        @RequestParam String country,
	        @RequestParam String postalCode
	        ) {
		        
    	Customer cust = redisRepository.findCustomer(key);
		cust.setFirstName(firstName);
		cust.setLastName(lastName);
		cust.setContactNo(contactNo);
		cust.getAddress().setId(addressType);
		cust.getAddress().setAddressLine1(addressLine1);
		cust.getAddress().setAddressLine2(addressLine2);
		cust.getAddress().setCity(city);
		cust.getAddress().setCountry(country);
		cust.getAddress().setPostalCode(postalCode);
		
		redisRepository.update(cust);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
