package com.mobiles.service;

import com.mobiles.model.Cart;

public interface CartService {
	public Cart getCart(String crtid);
	public abstract int sizeOfCart(Cart cart);
	public void updateItemsToCart(Cart crt);
}
