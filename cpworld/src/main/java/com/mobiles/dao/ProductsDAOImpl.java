package com.mobiles.dao;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mobiles.model.Products;
@Repository
public class ProductsDAOImpl implements ProductsDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void addProducts(Products prd) {
		Session ses= sessionFactory.openSession();
		Transaction tr= ses.beginTransaction();
		prd.setProductid(generateProductId());
		ses.save(prd);
		saveProductImage(prd);
		tr.commit();
		ses.close();
		
	}
	
	

	public String generateProductId(){
		
		String newPid="";
		Session s= sessionFactory.openSession();
		Query qr=s.createQuery("from Products");
		List<Products> data=qr.list();
		if(data.size()==0){
			newPid="PRD00001";
		}
		else{
			Session ss=sessionFactory.openSession();
			Query q=ss.createQuery("select max(productid) from Products");
			String prevId=q.list().get(0).toString();
			System.out.println("prev id" +prevId);
			int id=Integer.parseInt(prevId.substring(3));
			id=id+1;
			if(id<=9)
				newPid="PRD0000"+id;
			else if(id<=99)
				newPid="PRD000"+id;
			else if(id<=999)
				newPid="PRD00"+id;
			else if(id<=9999)
				newPid="PRD0"+id;
			else
				newPid="PRD"+id;		
			System.out.print("\nGenerated : "+newPid);
			
			ss.close();

		}	
		return newPid;
	}
	
	
	
	@Transactional
	public List<Products> getProductsAdmin(){
		Session ses=sessionFactory.openSession();
		Query q= ses.createQuery("from Products");
		List<Products> data=q.list();
		ses.close();
		return data;
	}
	
	

	private void saveProductImage(Products prd){
		System.out.print("\nprd img : " + prd.getImagefile());	
		try{
			if(prd.getImagefile()!=null){
				Path path=Paths.get("E:/DBworkspace/cpworld/src/main/webapp/resources/images/products/"+prd.getProductid()+".jpg");
				prd.getImagefile().transferTo(new File(path.toString()));
				System.out.print("\nProduct Image saved");	
			}
		}
		catch(Exception e){
			System.out.print("\nProduct Image not saved...");
		}
		
	}
	
	
	@Transactional
	public void deleteProduct(String productid){
		Session ses=sessionFactory.openSession();
		Products prd=(Products)ses.get(Products.class, productid);
		ses.delete(prd);
		ses.flush();
		ses.close();
	}
	
	@Transactional
	public Products getProductById(String pid){
		Session ses=sessionFactory.openSession();
		Products prd=(Products)ses.get(Products.class, pid);
		ses.close();
		return prd;		
	}
	
	
	
	@Transactional
	public void updateProductsToDB(Products prd){
		Session ses=sessionFactory.openSession();
		Transaction tr= ses.beginTransaction();
		ses.update(prd);
		tr.commit();
		ses.close();
	}
	


}
