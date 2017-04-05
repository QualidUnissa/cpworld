package com.mobiles.service;

import com.mobiles.model.CartItem;

public interface CartItemService {
	public abstract void addCartItem(CartItem cartitem);
	public abstract void removeItemfromCart(String crmid);
	public abstract void clearCart(String cstmrid);
}
