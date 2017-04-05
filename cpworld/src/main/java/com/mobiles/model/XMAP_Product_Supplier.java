package com.mobiles.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class XMAP_Product_Supplier {
	@Id
	private String psid;
	private String productid;
	private String supplierid;
	private int productsupplierprice;
	private int productsupplierstock;
	private boolean isproductsupplieravailable;
	public String getPsid() {
		return psid;
	}
	public void setPsid(String psid) {
		this.psid = psid;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public int getProductsupplierstock() {
		return productsupplierstock;
	}
	public void setProductsupplierstock(int productsupplierstock) {
		this.productsupplierstock = productsupplierstock;
	}
	public boolean isIsproductsupplieravailable() {
		return isproductsupplieravailable;
	}
	public void setIsproductsupplieravailable(boolean isproductsupplieravailable) {
		this.isproductsupplieravailable = isproductsupplieravailable;
	}
	public String getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}
	public int getProductsupplierprice() {
		return productsupplierprice;
	}
	public void setProductsupplierprice(int productsupplierprice) {
		this.productsupplierprice = productsupplierprice;
	}

}
