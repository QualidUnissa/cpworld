package com.mobiles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobiles.dao.CartDAO;
import com.mobiles.model.Cart;
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDAO cartdao;
	public Cart getCart(String crtid) {
		return cartdao.getCart(crtid);
	}
	public int sizeOfCart(Cart cart) {
		return cartdao.sizeOfCart(cart);
	}
	
	public void updateItemsToCart(Cart crt) {
		cartdao.updateItemsToCart(crt);
		
	}
	
	

}
