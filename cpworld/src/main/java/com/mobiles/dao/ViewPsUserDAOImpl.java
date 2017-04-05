package com.mobiles.dao;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mobiles.model.ViewXmapPS;
@Repository
public class ViewPsUserDAOImpl implements ViewPsUserDAO {
@Autowired
private SessionFactory sessionfactory;

	

	@Transactional
	public List<ViewXmapPS> displayproductsUser() {
		Session s= sessionfactory.openSession();
		
		Query q=s.createQuery("from ViewXmapPS");
		List<ViewXmapPS> data=q.list();
		return data;
	}
	@Transactional
	public List<ViewXmapPS> getBestViewProducts() {
		Session ses = sessionfactory.openSession();
		int num=randomNumforThumbnails();
		//String qry = "from ViewXmapPS x1 where productsupplierprice=(select min(productsupplierprice) from ViewXmapPS x2 where x1.productid=x2.productid)";
		System.out.println(+num);
		String qry = "from ViewXmapPS x1 where productsupplierprice=(select min(productsupplierprice) from ViewXmapPS x2 where x1.productid=x2.productid) order by " +num;
		Query qr = ses.createQuery(qry);
		List<ViewXmapPS> data = qr.list();
		ses.close();
		return data;
	}
	@Transactional
	public List<ViewXmapPS> getAllSupplierProducts(String pid) {
		Session ses=sessionfactory.openSession();
		String str="from ViewXmapPS where productid=?";
		Query qr=ses.createQuery(str);
		qr.setParameter(0,pid);
		List<ViewXmapPS> data=qr.list();
		ses.close();
		return data;
	}
	@Transactional
	public int randomNumforThumbnails(){
		int min,max;
		min=1;
		max=6;
		Random random= new Random();
		int number= random.nextInt((max-min)+1)+min;
		return number;
	}
	
	

}
