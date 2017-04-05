package com.mobiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerOrderController {
	
	 @RequestMapping("/order/{cartId}")
	 public String checkOutProcess(@PathVariable String cartId){
		 System.out.println("cartid"+cartId);
		 return "redirect:/checkOut?cartId=";
	 }

}
