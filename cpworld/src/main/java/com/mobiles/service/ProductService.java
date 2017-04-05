package com.mobiles.service;

import java.util.List;

import com.mobiles.model.Products;

public interface ProductService {
	public void addProducts(Products prd);
	public abstract List<Products> getProductsAdmin();
	void deleteProduct(String productid);
	//public Products editProduct(String productid);
	public Products getProductById(String pid); 
	public void updateProductsToDB(Products prd);
}
