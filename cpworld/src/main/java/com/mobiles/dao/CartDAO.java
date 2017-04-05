package com.mobiles.dao;

import com.mobiles.model.Cart;

public interface CartDAO {
	public Cart getCart(String crtid);
	public abstract int sizeOfCart(Cart cart);
	public void updateItemsToCart(Cart crt);

}
