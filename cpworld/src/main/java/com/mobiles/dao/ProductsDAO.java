package com.mobiles.dao;

import java.util.List;

import com.mobiles.model.Products;

public interface ProductsDAO {
	public void addProducts(Products prd);
	public abstract List<Products> getProductsAdmin();
	void deleteProduct(String productid);
	//public void editProduct(String productid);
	public Products getProductById(String pid);
	public void updateProductsToDB(Products prd);

}
