package com.workerservices.dao;

import java.util.List;

import com.workerservices.model.CityData;
import com.workerservices.model.CountryData;
import com.workerservices.model.Customer;
import com.workerservices.model.CustomerAddress;

public interface Customer_DAO {
	
	List<Customer> getAllCustomer();
	CustomerAddress getAddressById(int id);
	
	
	
	int saveCustomer(Customer cus);
	int saveAddress(CustomerAddress add);
	
	Customer getCustoemerById(int id);
	Customer getCustoemerByEmail(String email);
}
