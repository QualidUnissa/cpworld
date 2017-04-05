package com.mobiles.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mobiles.model.ViewXmapPS;
import com.mobiles.service.ViewPsUserService;

@Controller
public class UserController {
	@Autowired
	private ViewPsUserService viewpsService;
	
	//request to display all products for user
	@RequestMapping("/reqdisplaypoductsuser")
	public String displayproductsuser(Model m,HttpSession hsession){
	//List<ViewXmapPS> prd=viewpsService.displayproductsUser();//to display all products
	List<ViewXmapPS> prd=viewpsService.getBestViewProducts();// to display best product
	m.addAttribute("products",prd);
	m.addAttribute("username",hsession.getAttribute("userlogin"));
	m.addAttribute("userid",hsession.getAttribute("userimage"));
	m.addAttribute("cartsize",hsession.getAttribute("sizeofcart"));
	return "displayProductsUser";
	}
	
	
	//request to display more suppliers of one product with different price/stock
	@RequestMapping("/formoreSupplierProducts")
	public String formoreSupplierProducts(@RequestParam("prd")String vps,Model m,HttpSession hsession){
	List<ViewXmapPS> data=viewpsService.getAllSupplierProducts(vps);
	m.addAttribute("prdid",data.get(0).getProductid());
	m.addAttribute("prdname",data.get(0).getProductname());
	m.addAttribute("allsuppliers",data);
	m.addAttribute("username",hsession.getAttribute("userlogin"));
	m.addAttribute("userid",hsession.getAttribute("userimage"));
	return "allSupplierProducts";
	}
	
	}
