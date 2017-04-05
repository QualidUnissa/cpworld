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
import com.mobiles.model.Suppliers;
@Repository
public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	public  void addSuppliers(Suppliers sp){
		

			Session ses= sessionFactory.openSession();
			Transaction tr= ses.beginTransaction();
			sp.setSupplierid(generateSupplierId());
			ses.save(sp);
			saveSupplierImage(sp);
			tr.commit();
			ses.close();
			
		}
		
		public String generateSupplierId(){
			
			String newSid="";
			Session s= sessionFactory.openSession();
			Query qr=s.createQuery("from Suppliers");
			List<Suppliers> data=qr.list();
			if(data.size()==0){
				newSid="SUP00001";
			}
			else{
				Session ss=sessionFactory.openSession();
				Query q=ss.createQuery("select max(supplierid) from Suppliers");
				String prevId=q.list().get(0).toString();
				System.out.println("prev id" +prevId);
				int id=Integer.parseInt(prevId.substring(3));
				id=id+1;
				if(id<=9)
					newSid="SUP0000"+id;
				else if(id<=99)
					newSid="SUP000"+id;
				else if(id<=999)
					newSid="SUP00"+id;
				else if(id<=9999)
					newSid="SUP0"+id;
				else
					newSid="SUP"+id;		
				System.out.print("\nGenerated : "+newSid);
				
				ss.close();

			}	
			return newSid;
		}
		private void saveSupplierImage(Suppliers sup){
			System.out.print("\nprd img : " + sup.getImagefile());	
			try{
				if(sup.getImagefile()!=null){
					Path path=Paths.get("E://DBworkspace//cpworld//src//main//webapp//resources//images//suppliers//"+sup.getSupplierid()+".jpg");
					sup.getImagefile().transferTo(new File(path.toString()));
					System.out.print("\nProduct Image saved");	
				}
			}
			catch(Exception e){
				System.out.print("\nProduct Image not saved...");
			}
			
		}
		@Transactional
		public List<Suppliers> displaySuppliers(){
			Session s= sessionFactory.openSession();
			Query qr=s.createQuery("from Suppliers");
			List<Suppliers> data=qr.list();
			s.close();
			return data;
		}
		
		@Transactional
		public Suppliers getSupplierById(String sid) {
			Session ses= sessionFactory.openSession();
			Suppliers supid=(Suppliers)ses.get(Suppliers.class,sid);
			ses.close();
			return supid;
		}
		@Transactional
		public void updateSupliers(Suppliers sup) {
			Session ses=sessionFactory.openSession();
			Transaction tr= ses.beginTransaction();
			ses.update(sup);
			tr.commit();
			ses.close();
		}
		@Transactional
		public void deleteSupliers(String sup) {
			Session ses=sessionFactory.openSession();
			Transaction tr=ses.beginTransaction();
			Suppliers spid=(Suppliers)ses.get(Suppliers.class, sup);
			ses.delete(spid);
			tr.commit();
			ses.close();
		}
		
		
		
		
	

}
