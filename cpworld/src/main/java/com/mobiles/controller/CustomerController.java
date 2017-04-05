package com.mobiles.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mobiles.model.BillingAddress;
import com.mobiles.model.Cart;
import com.mobiles.model.Customer;
import com.mobiles.model.ShippingAddress;
import com.mobiles.model.UserDetailsNew;
import com.mobiles.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customerSignupForm")
	public String customerSignupForm(Model m){
		
		m.addAttribute("customerObj",new Customer());
		return "customerform";
	}
	
	
	
	@RequestMapping("/addCustomerSignUpDataToDB")
	public String SignUpDataToDB(@ModelAttribute("customerObj")Customer customer,Model m,HttpSession hses){
	
		m.addAttribute("username",hses.getAttribute("userlogin"));
		m.addAttribute("userid",hses.getAttribute("userimage"));
		
		Cart cart=new Cart();
		BillingAddress blAdd=new BillingAddress();
		blAdd.setFlatno(customer.getShippingAddress().getFlatno());
		blAdd.setStreet(customer.getShippingAddress().getStreet());
		blAdd.setArea(customer.getShippingAddress().getArea());
		blAdd.setZipcode(customer.getShippingAddress().getZipcode());
		blAdd.setCountry(customer.getShippingAddress().getCountry());
		blAdd.setLandmark(customer.getShippingAddress().getLandmark());
		customer.setBillingAddress(blAdd);
		customer.setCart(cart);
		 
		
		

		/*UserDetailsNew userdetails=new UserDetailsNew();
		
		ShippingAddress shippingAddress=new ShippingAddress();
		
	*/

	
		String usid=customerService.addCustomerData(customer);
		System.out.print(usid);
		
		/*customer.setUserdetails(userdetails);
		customer.setShippingAddress(shippingAddress);*/
		m.addAttribute("message","SignUp Successfull. Your User ID is "+usid);
	/*	Customer cust= new Customer();

		cust.setUserdetails(userdetails);
		cust.setShippingAddress(shippingAddress);*/
		return "springLoginForm";
	}
	
	@RequestMapping("/editCustomerProfileForm")
	public String editProfileForm(@RequestParam("uid")String cstid,Model m,HttpSession hses){
		Customer data=customerService.getCustomerByCustomerId(cstid);
		//Customer cust=customerService.getCustomerById(hses.getAttribute("userimage").toString());
				m.addAttribute("username",hses.getAttribute("userlogin"));
		m.addAttribute("userid",hses.getAttribute("userimage"));
		m.addAttribute("customerData",data);
		//System.out.print(usid);
		return "editCustomerProfile";
	}
	@RequestMapping("/updateCustomerDataToDB")
	public String editProfileDataToDB(@ModelAttribute("customerData")Customer customer){
	
		/*BillingAddress blAdd=new BillingAddress();
		blAdd.setFlatno(customer.getShippingAddress().getFlatno());
		blAdd.setStreet(customer.getShippingAddress().getStreet());
		blAdd.setArea(customer.getShippingAddress().getArea());
		blAdd.setZipcode(customer.getShippingAddress().getZipcode());
		blAdd.setCountry(customer.getShippingAddress().getCountry());
		blAdd.setLandmark(customer.getShippingAddress().getLandmark());
		customer.setBillingAddress(blAdd);
		customerService.updateEditProfileToDB(customer);*/
		return "redirect:/loginCheck1";
	}
	

}
