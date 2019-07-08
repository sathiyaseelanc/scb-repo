package com.scb.retail.repository;

import java.util.List;
import java.util.Map;

import com.scb.retail.model.Customer;

public interface RedisRepository {

    /**
     * Return all movies
     */
    Map<Object, Object> findAllCustomer();

    /**
     * Add key-value pair to Redis.
     */
    void add(Customer cust);

    /**
     * Delete a key-value pair in Redis.
     */
    void delete(String id);
    
    /**
     * find a movie
     */
    Customer findCustomer(String id);
    
    List<Customer> findAllCustomerList();
    
    List<Customer> findAllMultiGet();
    
    void update(Customer cust);
}
