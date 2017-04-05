package com.mobiles.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CustomerOrder implements Serializable {
	@Id
	private String orderId;
	
	@OneToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name="billingAddressId")
	private BillingAddress billingAddress;
	
	
	@OneToOne
	@JoinColumn(name="shippingAddressId")
	private ShippingAddress shippingAddress;
	
	
	@OneToOne
	@JoinColumn(name="cartId")
	private Cart cart;
	
	
	@OneToMany(mappedBy="customerOrder",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<CustomerOrderHistory> CutomerOrderHistory;
	
	
	
	
	

	public List<CustomerOrderHistory> getCutomerOrderHistory() {
		return CutomerOrderHistory;
	}


	public void setCutomerOrderHistory(List<CustomerOrderHistory> cutomerOrderHistory) {
		CutomerOrderHistory = cutomerOrderHistory;
	}


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public BillingAddress getBillingAddress() {
		return billingAddress;
	}


	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}


	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}


	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	

}
