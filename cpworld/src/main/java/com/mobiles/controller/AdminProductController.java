package com.mobiles.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mobiles.model.Products;
import com.mobiles.model.Suppliers;
import com.mobiles.model.UserDetails;
import com.mobiles.model.UserDetailsNew;
import com.mobiles.model.XMAP_Product_Supplier;
import com.mobiles.service.ProductService;
import com.mobiles.service.SupplierService;
import com.mobiles.service.UserDetailsNewService;
import com.mobiles.service.UserDetailsService;
import com.mobiles.service.XmpsService;
@Controller
public class AdminProductController {
	@Autowired
	private ProductService productservice;
	@Autowired
	private SupplierService supplierservice;
	@Autowired
	private XmpsService xmpsService;
	@Autowired
	private UserDetailsService userdetailsService;
	@Autowired
	private UserDetailsNewService userdetailsnewService;
	
	
	//request to display add products form
	@RequestMapping("/reqAddProductsPage")
	public String addProducts(Model m,HttpSession hsession){
		m.addAttribute("productsObj",new Products());
		m.addAttribute("username",hsession.getAttribute("userlogin"));
		m.addAttribute("userid",hsession.getAttribute("userimage"));
		m.addAttribute("bgnum",RandomController.randomNumberGeneration());
		return "addproducts";
	}
	
	
	//request to add products to data base
	@RequestMapping("/addProductstoDB")
	public String addProductstoDB(@Valid @ModelAttribute("productsObj")Products prd,Model m,HttpSession hsession,BindingResult result){
		if(result.hasErrors())
			return "addproducts";
		
		productservice.addProducts(prd);
		m.addAttribute("products",prd);
		m.addAttribute("username",hsession.getAttribute("userlogin"));
		m.addAttribute("userid",hsession.getAttribute("userimage"));
		m.addAttribute("bgnum",RandomController.randomNumberGeneration());
		return "loginAdmin";
	} 
	
	
	//request to display products to admin
	@RequestMapping("/reqDispalyProductsAdmin")
	public String displayProductsAdmin(Model m,HttpSession hsession){
	List<Products> data=productservice.getProductsAdmin();
	m.addAttribute("products",data);
	m.addAttribute("username",hsession.getAttribute("userlogin"));
	m.addAttribute("userid",hsession.getAttribute("userimage"));
	m.addAttribute("bgnum",RandomController.randomNumberGeneration());
		return "displayProductsAdmin";
	}
	
	// request to delete products
	@RequestMapping("/reqDeleteProduct/{productid}")
	public String deleteProduct(@PathVariable String productid,HttpSession hsession,Model m){
		productservice.deleteProduct(productid);
		m.addAttribute("username",hsession.getAttribute("userlogin"));
		m.addAttribute("userid",hsession.getAttribute("userimage"));
		m.addAttribute("bgnum",RandomController.randomNumberGeneration());
		return "redirect:/reqDispalyProductsAdmin";
	}
	
	
	
	//request to display add supplier form
	@RequestMapping("/reqAddSupplierform")
	public String addSuppliers(Model m,HttpSession hsession){
		m.addAttribute("suppliersObj",new Suppliers());
		m.addAttribute("username",hsession.getAttribute("userlogin"));
		m.addAttribute("userid",hsession.getAttribute("userimage"));
		m.addAttribute("bgnum",RandomController.randomNumberGeneration());
		return "addsupplier";
	}
	
	
	
	//request to add suppliers to data base
	@RequestMapping("/addSupplierstoDB")
	public String addSupplierstoDb(@ModelAttribute("suppliersObj")Suppliers sp,Model m,HttpSession hsession){
		supplierservice.addSuppliers(sp);
		m.addAttribute("suppliers",sp);
		m.addAttribute("username",hsession.getAttribute("userlogin"));
		m.addAttribute("userid",hsession.getAttribute("userimage"));
		m.addAttribute("bgnum",RandomController.randomNumberGeneration());
		return "loginAdmin";
	}
	
	
	
	//request to display list of suppliers
	@RequestMapping("/reqDisplayAllSuppliers")
	public String displayAllSuppliers(Model m,HttpSession hsession){
		List<Suppliers> data=supplierservice.displaySuppliers();
		m.addAttribute("supplier",data);
		m.addAttribute("username",hsession.getAttribute("userlogin"));
		m.addAttribute("userid",hsession.getAttribute("userimage"));
		m.addAttribute("bgnum",RandomController.randomNumberGeneration());
		return "displaySuppliersAdmin";
	}
	
	
	
	//request to add (xmap) productsuppliers form
	@RequestMapping("/reqAddProductSupplierForm")
	public String addProductSupplier(Model m,HttpSession hsession){
		List<Products> prd=productservice.getProductsAdmin();
		List<Suppliers> sup= supplierservice.displaySuppliers();
		m.addAttribute("products",prd);
		m.addAttribute("supplier",sup);
		m.addAttribute("xmapObj",new XMAP_Product_Supplier());
		m.addAttribute("username",hsession.getAttribute("userlogin"));
		m.addAttribute("userid",hsession.getAttribute("userimage"));
		return "addxmapPSform";
	}
	
	
	//request to add (xmap) productsuppliers to data base
	@RequestMapping("/addXmpstoDB")
	public String addXmpstodb(@ModelAttribute("xmapObj")XMAP_Product_Supplier xmps,HttpSession hsession,Model m){
		xmpsService.addXmps(xmps);
		m.addAttribute("username",hsession.getAttribute("userlogin"));
		m.addAttribute("userid",hsession.getAttribute("userimage"));
		return "redirect:/reqDisplayXmps";
		//return "loginAdmin";
	}
	
	
	//request to display list  of (xmap) productsuppliers
	@RequestMapping("/reqDisplayXmps")
	public String displayxmps(Model m,HttpSession hsession){
		List<XMAP_Product_Supplier> xps=xmpsService.displayXmps();
		m.addAttribute("xmpsData",xps);
		m.addAttribute("username",hsession.getAttribute("userlogin"));
		m.addAttribute("userid",hsession.getAttribute("userimage"));
		m.addAttribute("bgnum",RandomController.randomNumberGeneration());
		return "displayXmps";
	}
	
	
	
	
	//request  to display edit products form
	@RequestMapping("/reqEditProductPage")//to display edit jsp
	public String editProductAdmin(@RequestParam("prd")String productid,Model m,HttpSession hsession){
		Products prd= productservice.getProductById(productid); 
		m.addAttribute("productsData",prd);
		m.addAttribute("username",hsession.getAttribute("userlogin"));
		m.addAttribute("userid",hsession.getAttribute("userimage"));
		System.out.println(prd.getProductid() + prd.getProductname() + prd.getProductdesc());
		return "editproductpage";
	}
	
	
	//request to save edited data to DB
	@RequestMapping("/editProductstoDB")
	public String editProductToDB(@ModelAttribute("productsData")Products prd, HttpSession hsession,Model m){
		productservice.updateProductsToDB(prd);
		
		m.addAttribute("username",hsession.getAttribute("userlogin"));
		m.addAttribute("userid",hsession.getAttribute("userimage"));
		return "redirect:/reqDispalyProductsAdmin";
		
	}
	
	
	
	
	//request to display edit suppleirs form
	@RequestMapping("/reqEditSuppliersPage")
	public String editSuppliersform(@RequestParam("spid")String supid,Model m,HttpSession hsession){
		Suppliers supplier=supplierservice.getSupplierById(supid);
		m.addAttribute("supplierData",supplier);
		m.addAttribute("username",hsession.getAttribute("userlogin"));
		m.addAttribute("userid",hsession.getAttribute("userimage"));
		return "editSuppliersform";
	}
	
	
	//request to add edited suppliers data to db
	@RequestMapping("/editSupplierstoDB")
	public String editSupplierstoDB(@ModelAttribute("supplierData")Suppliers spid,Model m, HttpSession hsession){
		supplierservice.updateSupliers(spid);
		m.addAttribute("username",hsession.getAttribute("userlogin"));
		m.addAttribute("userid",hsession.getAttribute("userimage"));
		return "redirect:/reqDisplayAllSuppliers";
	}
	
	
	
	//request to delete suppliers
	@RequestMapping("/reqDeleteSupplier/{supplierid}")
	public String deleteSupplierfromDB(@PathVariable String supplierid,Model m,HttpSession hsession){
		supplierservice.deleteSupliers(supplierid);
		m.addAttribute("username",hsession.getAttribute("userlogin"));
		m.addAttribute("userid",hsession.getAttribute("userimage"));
		return "redirect:/reqDisplayAllSuppliers";
	}
	
	
	
	//request to delete Productsupplier
	@RequestMapping("/reqDeleteProductSupplier/{psid}")
	public String deleteProductSupplierfromDB(@PathVariable String psid,Model m,HttpSession hsession){
		xmpsService.deleteProductSupliers(psid);
		m.addAttribute("username",hsession.getAttribute("userlogin"));
		m.addAttribute("userid",hsession.getAttribute("userimage"));
		return "redirect:/reqDisplayXmps";
	}
	
	//request to display edit ProductSuppliers form
	@RequestMapping("/reqEditProductSuppliersPage")
	public String editProductSupplierform(@RequestParam("prdsup")String prdsp,Model m,HttpSession hsession){
		XMAP_Product_Supplier xmps=xmpsService.getProductSupliersById(prdsp);
		m.addAttribute("username",hsession.getAttribute("userlogin"));
		m.addAttribute("userid",hsession.getAttribute("userimage"));
		m.addAttribute("psData",xmps);
		return "editXmapPSForm";
	}
	
	
	//request to add edited data ofXMPS to DB
	@RequestMapping("/reqEditXmpstoDB")
	public String editProductSupplierstoDB(@ModelAttribute("psData")XMAP_Product_Supplier prdsupp,Model m,HttpSession hsession){
		xmpsService.updateProductSupplierstoDB(prdsupp);
		m.addAttribute("username",hsession.getAttribute("userlogin"));
		m.addAttribute("userid",hsession.getAttribute("userimage"));
		return "redirect:/reqDisplayXmps";
	}
	@RequestMapping("/displayUserDetailsList")
	public String displayUserdetails(Model m){
		List<UserDetailsNew> ud=userdetailsnewService.getUserDetailsList();
		m.addAttribute("userdata",ud);
		return "manageUsers";
	}
	
	@RequestMapping("/disableUser")
	public String manageUsers(@RequestParam("uid")String ud){
		userdetailsnewService.disableuser(ud);
		return "redirect:/displayUserDetailsList";
	}
 	@RequestMapping("/enableUser")
	public String enableUsers(@RequestParam("uid")String ud){
		userdetailsnewService.enableuser(ud);
		return "redirect:/displayUserDetailsList";
	}
}
