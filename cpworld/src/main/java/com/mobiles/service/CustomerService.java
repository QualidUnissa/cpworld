package com.mobiles.service;

import com.mobiles.model.Customer;


public interface CustomerService {
	public String addCustomerData(Customer customer);
	public Customer getCustomerById(String usrid);
	public Customer getCustomerByCustomerId(String cstid);
	public void updateEditProfileToDB(Customer cust);

}
