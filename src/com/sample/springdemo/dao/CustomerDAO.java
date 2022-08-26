package com.sample.springdemo.dao;

import com.sample.springdemo.entity.Customer;
import org.springframework.stereotype.Controller;

import java.util.List;


public interface CustomerDAO {


    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public void deleteCustomer(int theId);

    public Customer getCustomer(int theId);

    List<Customer> searchCustomers(String theSearchName);
}
