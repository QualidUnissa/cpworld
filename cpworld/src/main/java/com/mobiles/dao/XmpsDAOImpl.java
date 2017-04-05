package com.mobiles.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mobiles.model.Products;
import com.mobiles.model.XMAP_Product_Supplier;
@Repository
public class XmpsDAOImpl implements XmpsDAO {
@Autowired
private SessionFactory s1;
@Transactional
	public void addXmps(XMAP_Product_Supplier xmps) {
		Session ses= s1.openSession();
		Transaction tr= ses.beginTransaction();
		xmps.setPsid(generateXmpsId());
		ses.save(xmps);
		tr.commit();
		ses.close();
	}
@Transactional
private String generateXmpsId(){
	String newXPSid="";
	Session s= s1.openSession();
	Query qr=s.createQuery("from XMAP_Product_Supplier");
	List<XMAP_Product_Supplier> data=qr.list();
	if(data.size()==0){
		newXPSid="XPS00001";
	}
	else{
		Session ss=s1.openSession();
		Query q=ss.createQuery("select max(psid) from XMAP_Product_Supplier");
		String prevId=q.list().get(0).toString();
		System.out.println("prev id" +prevId);
		int id=Integer.parseInt(prevId.substring(3));
		id=id+1;
		if(id<=9)
			newXPSid="XPS0000"+id;
		else if(id<=99)
			newXPSid="XPS000"+id;
		else if(id<=999)
			newXPSid="XPS00"+id;
		else if(id<=9999)
			newXPSid="XPS0"+id;
		else
			newXPSid="XPS"+id;		
		System.out.print("\nGenerated : "+newXPSid);
		
		ss.close();

	}	
	return newXPSid;
}
@Transactional
	public List<XMAP_Product_Supplier> displayXmps() {
		Session ses= s1.openSession();
		Query qr= ses.createQuery("from XMAP_Product_Supplier");
		List<XMAP_Product_Supplier> data= qr.list();
		ses.close();
		return data;
	}
	@Transactional
	public void deleteProductSupliers(String psd) {
		Session ses=s1.openSession();
		XMAP_Product_Supplier ps=(XMAP_Product_Supplier)ses.get(XMAP_Product_Supplier.class, psd);
		ses.delete(ps);
		ses.flush();
		ses.close();
	
	}
	@Transactional
	public XMAP_Product_Supplier getProductSupliersById(String psd) {
		Session ses=s1.openSession();
		XMAP_Product_Supplier ps=(XMAP_Product_Supplier)ses.get(XMAP_Product_Supplier.class, psd);
		ses.close();
		return ps;	
	}

	@Transactional
	public void updateProductSupplierstoDB(XMAP_Product_Supplier psd) {
		Session ses=s1.openSession();
		Transaction tr= ses.beginTransaction();
		ses.update(psd);
		tr.commit();
		ses.close();	
	}
	
}
