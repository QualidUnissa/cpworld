package com.mobiles.dao;

import com.mobiles.model.CartItem;

public interface CartItemDAO {
	public abstract void addCartItem(CartItem cartitem);
	public abstract void removeItemfromCart(String crmid);
	public abstract void clearCart(String cstmrid);
}
