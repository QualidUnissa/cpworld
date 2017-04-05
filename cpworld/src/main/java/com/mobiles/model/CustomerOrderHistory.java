package com.mobiles.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CustomerOrderHistory {
	@Id
	private String orderhistoryId;
	
	private String productid;
	private String supplierid;
	private int quantity;
	private int price;
	private int total;
	private boolean reviewgiven;
	
	@ManyToOne
	@JoinColumn(name="orderId")
	private CustomerOrder customerOrder;
	
	
	public String getOrderhistoryId() {
		return orderhistoryId;
	}
	public void setOrderhistoryId(String orderhistoryId) {
		this.orderhistoryId = orderhistoryId;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public boolean isReviewgiven() {
		return reviewgiven;
	}
	public void setReviewgiven(boolean reviewgiven) {
		this.reviewgiven = reviewgiven;
	}
	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}
	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}
	
	
	
}
