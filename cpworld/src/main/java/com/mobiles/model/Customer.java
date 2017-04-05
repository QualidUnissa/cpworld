package com.mobiles.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;
@Entity
public class Customer {
	@Id
	private String customerId;
	private String customerName;
	private String email;
	private String mobile;
	
	@Transient
	private MultipartFile imagefile;
	
	
	

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userid")
	private UserDetailsNew userdetails;
	

	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="shippingAddressId")
	private ShippingAddress shippingAddress;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="billingAddressId")
	private BillingAddress billingAddress;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cartId")
	private Cart cart;
	
	
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	
	public MultipartFile getImagefile() {
		return imagefile;
	}
	public void setImagefile(MultipartFile imagefile) {
		this.imagefile = imagefile;
	}
	public UserDetailsNew getUserdetails() {
		return userdetails;
	}
	public void setUserdetails(UserDetailsNew userdetails) {
		this.userdetails = userdetails;
	}
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}

}
