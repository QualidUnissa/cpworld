package com.mobiles.dao;

import java.util.List;

import com.mobiles.model.Customer;

public interface CustomerDAO {
		
	public String addCustomerData(Customer customer);
	public Customer getCustomerById(String usrid);
	public Customer getCustomerByCustomerId(String cstid);
	public void updateEditProfileToDB(Customer cust);
}
