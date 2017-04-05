package com.mobiles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobiles.dao.ProductsDAO;
import com.mobiles.model.Products;
@Service
public class ProductServiceImpl implements ProductService {
@Autowired
private ProductsDAO productsdao;
	public void addProducts(Products prd) {
		productsdao.addProducts(prd);

	}
	public List<Products> getProductsAdmin(){
		return productsdao.getProductsAdmin();
	}
	public void deleteProduct(String productid){
		productsdao.deleteProduct(productid);
	}
	/*public Products editProduct(String productid){
		return productsdao.editProduct(productid);
	}
*/
	public Products getProductById(String pid) {
		// TODO Auto-generated method stub
		return productsdao.getProductById(pid);
	}
	
	public void updateProductsToDB(Products prd){
		productsdao.updateProductsToDB(prd);
	}
	
	
}
