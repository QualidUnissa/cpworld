package com.mobiles.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mobiles.model.Cart;
import com.mobiles.model.CartItem;
import com.mobiles.model.Customer;
import com.mobiles.model.UserDetailsNew;
import com.mobiles.model.ViewXmapPS;
import com.mobiles.model.XMAP_Product_Supplier;
import com.mobiles.service.CartItemService;
import com.mobiles.service.CartService;
import com.mobiles.service.CustomerService;
import com.mobiles.service.UserDetailsNewService;
import com.mobiles.service.XmpsService;

@Controller
public class CartItemController {
	  @Autowired
	  private CustomerService customerservice;
	  @Autowired
	  private UserDetailsNewService userservice;
	  @Autowired
	  private CartItemService cartitemService;
	  @Autowired
	  private CartService cartservice;
	  @Autowired
	  private XmpsService xmpsService;
	  
	  
	  @RequestMapping("/AddItemToCart/{psid}")
	  public String addItemtoCart(@PathVariable("psid")String psid,@RequestParam("qty")int qty,Model m,Principal princp,HttpSession hses){
		 // UserDetailsNew usrd=userservice.getUserById(usrid);
		 
		  String userid=princp.getName();
		  System.out.println(userid);
		  System.out.println("before controller");
		  Customer cust=customerservice.getCustomerById(userid);
		  System.out.println("aftter controller");
		  System.out.println(cust.getCart().getCartId());
		  Cart cart=cust.getCart();
		  XMAP_Product_Supplier xmpProduct=xmpsService.getProductSupliersById(psid);
		  
		  CartItem cartitem=new CartItem();
		  //cartitem.getCartitemId();
		  cartitem.setCart(cart);
		  cartitem.setXmapPS(xmpProduct);
		  cartitem.setQuantity(qty);
		  cartitem.setItemwisetotal(xmpProduct.getProductsupplierprice()*qty);
		  cartitemService.addCartItem(cartitem);
		  Customer customer1=customerservice.getCustomerById(userid);
		  Cart cart1=customer1.getCart();
		  System.out.println(cartservice.sizeOfCart(cart));
		  System.out.println("size of cart:"+cartservice.sizeOfCart(cart1));
		  int cartsize=cartservice.sizeOfCart(cart1);
		  
		 
		  List<CartItem> cartitems= cart1.getCartItems();
		  int total=0;
		  for(CartItem crm:cartitems){
			  total+=crm.getItemwisetotal();
		  }
		  
		  System.out.println("grandTotal="+total);   
		  cart1.setGrandTotal(total);
		  cartservice.updateItemsToCart(cart1);
		  hses.setAttribute("sizeofcart",cartsize);
		  m.addAttribute("cartsize",hses.getAttribute("sizeofcart"));
		  return "redirect:/reqdisplaypoductsuser";
	  }
	  
	  
	 @RequestMapping("/displayCart")
	public String displayitemsInCart(Model m,Principal princ,HttpSession hses){
		 Customer custdisp= customerservice.getCustomerById(princ.getName());
		 Cart cart= custdisp.getCart();
		 List<CartItem> cartdata=cart.getCartItems();
		 m.addAttribute("cartitems",cartdata);
		 
		  int cartsize=cartservice.sizeOfCart(cart);
		  
		  int total=0;
		  for(CartItem crm:cartdata){
			  total+=crm.getItemwisetotal();
		  }
		  
		  System.out.println("grandTotal="+total);   
		  cart.setGrandTotal(total);
		  cartservice.updateItemsToCart(cart);
		  hses.setAttribute("sizeofcart",cartsize);
		  m.addAttribute("cartsize",hses.getAttribute("sizeofcart"));
		  m.addAttribute("customerid",custdisp.getCustomerId());
		 m.addAttribute("totalprice", cart.getGrandTotal());
		 m.addAttribute("customerData",custdisp);
		 return "displayCart";
	 }
	 
	 @RequestMapping("/removeFromCart/{cartitemId}")
	 public String removeItemsFromCart(@PathVariable("cartitemId")String cartitemId,Model m,HttpSession hses){
		 cartitemService.removeItemfromCart(cartitemId);
		 return "redirect:/displayCart";
	 }
	 @RequestMapping("/clearCart/{customerid}")
	public String clearCart(@PathVariable("customerid")String cstmrid,Model m, HttpSession hses){
		 cartitemService.clearCart(cstmrid);
		 hses.setAttribute("sizeofcart",0);
		 m.addAttribute("cartsize",hses.getAttribute("sizeofcart"));
		 return "redirect:/displayCart";
	 }
	 
	
	 
}
