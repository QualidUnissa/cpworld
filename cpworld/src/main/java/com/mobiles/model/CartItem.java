package com.mobiles.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class CartItem {
	@Id
	private String cartitemId;
	private int quantity;
	private int itemwisetotal;
	
	
	@ManyToOne
	@JoinColumn(name="cartId")
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name="psid")
	private XMAP_Product_Supplier xmapPS;
	
	
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public XMAP_Product_Supplier getXmapPS() {
		return xmapPS;
	}
	public void setXmapPS(XMAP_Product_Supplier xmapPS) {
		this.xmapPS = xmapPS;
	}
	public String getCartitemId() {
		return cartitemId;
	}
	public void setCartitemId(String cartitemId) {
		this.cartitemId = cartitemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getItemwisetotal() {
		return itemwisetotal;
	}
	public void setItemwisetotal(int itemwisetotal) {
		this.itemwisetotal = itemwisetotal;
	}
	
	
	

}
