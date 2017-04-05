package com.mobiles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobiles.dao.CartItemDAO;
import com.mobiles.model.CartItem;
@Service 
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemDAO cartitemdao;
	
	public void addCartItem(CartItem cartitem) {
		cartitemdao.addCartItem(cartitem);
	}

	
	public void removeItemfromCart(String crmid) {
		cartitemdao.removeItemfromCart(crmid);
	}

	
	public void clearCart(String cstmrid) {
	cartitemdao.clearCart(cstmrid);
		
	}
	
	
	

}
