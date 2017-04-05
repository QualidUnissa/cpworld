package com.mobiles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobiles.dao.CustomerDAO;
import com.mobiles.model.Customer;
@Service

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerdao;
	
	
	
	public String addCustomerData(Customer customer) {
		
		return customerdao.addCustomerData(customer);
	}



	public Customer getCustomerById(String usrid) {
		System.out.println("before service");
		Customer cust=customerdao.getCustomerById(usrid);
		System.out.println("after service");
		return cust;
		
	}




	public Customer getCustomerByCustomerId(String cstid) {
		
		return customerdao.getCustomerByCustomerId(cstid);
	}



	public void updateEditProfileToDB(Customer cust) {
		customerdao.updateEditProfileToDB(cust);
		
	}
	
	
	
	

}
