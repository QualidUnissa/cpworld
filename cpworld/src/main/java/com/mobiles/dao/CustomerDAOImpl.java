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

import com.mobiles.model.Customer;
import com.mobiles.model.UserDetails;


@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public String addCustomerData(Customer customer){
		Session ses= sessionFactory.openSession();
		 customer.setCustomerId(generateCustomerID());
		 customer.getUserdetails().setUserid(generateUserDetailsId());
		 customer.getShippingAddress().setShippingAddressId(generateShippingAddressid());
		 customer.getBillingAddress().setBillingAddressId(generateBillingAddressId());
		 customer.getCart().setCartId(generateCartId());
		 customer.getUserdetails().setEnable(true);
		 customer.getUserdetails().setRole("ROLE_USER");
		 saveCustomerImage(customer);
		 ses.save(customer);
		 ses.flush();		 
		 ses.close();
		//return customer.getUserdetails().getUserid();
		 return customer.getUserdetails().getUserid();
	}
	
	@Transactional
	public String generateCustomerID(){
		String cstid="";
		Session ses=sessionFactory.openSession();
		Query qr= ses.createQuery("from Customer");
		List<Customer> data=qr.list();
		ses.close();
		if(data.size()==0){
			cstid="CSR00001";
		}
		else{
			Session ss= sessionFactory.openSession();
			Query q=ss.createQuery("select max(customerId) from Customer");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);		
			id=id+1;
			if(id<=9)
				cstid="CSR0000"+id;
			else if(id<=99)
				cstid="CSR000"+id;
			else if(id<=999)
				cstid="CSR00"+id;
			else if(id<=9999)
				cstid="CSR0"+id;
			else
				cstid="CSR"+id;		
			System.out.print("\nGenerated : "+cstid);		
			ss.close();		
		}
		
		return cstid;
	}
	@Transactional
	private String generateUserDetailsId(){
		
		String newUid="";
		
		Session s = sessionFactory.openSession();
		Query qr = s.createQuery("from UserDetailsNew");
		List<UserDetails> data = qr.list();
		s.close();
		if(data.size()==0){
			newUid="USR00001";
		}
		else {			
			Session ss = sessionFactory.openSession();		
			Query q = ss.createQuery("select max(userid) from UserDetailsNew");
			String prevId = q.list().get(0).toString();
			System.out.println(prevId);
	
		System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);		
			id=id+1;
			if(id<=9)
				newUid="USR0000"+id;
			else if(id<=99)
				newUid="USR000"+id;
			else if(id<=999)
				newUid="USR00"+id;
			else if(id<=9999)
				newUid="USR0"+id;
			else
				newUid="USR"+id;		
			System.out.print("\nGenerated : "+newUid);
			
			ss.close();
		}
		return newUid;
	}
	@Transactional
	private String generateBillingAddressId(){		
		String newBid="";		
		Session s = sessionFactory.openSession();
		Query qr = s.createQuery("from BillingAddress");
		List<Customer> data = qr.list();
		s.close();
		if(data.size()==0){
			newBid="BAD00001";
		}
		else{
			Session ss = sessionFactory.openSession();		
			Query q = ss.createQuery("select max(billingAddressId) from BillingAddress");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);		
			id=id+1;
			if(id<=9)
				newBid="BAD0000"+id;
			else if(id<=99)
				newBid="BAD000"+id;
			else if(id<=999)
				newBid="BAD00"+id;
			else if(id<=9999)
				newBid="BAD0"+id;
			else
				newBid="BAD"+id;		
			System.out.print("\nGenerated : "+newBid);		
			ss.close();		
		}
			return newBid;
	}
	@Transactional
	private String generateShippingAddressid(){
		String newSid="";		
		Session s = sessionFactory.openSession();
		Query qr = s.createQuery("from ShippingAddress");
		List<Customer> data = qr.list();
		s.close();
		if(data.size()==0){
			newSid="SAD00001";
		}
		else{
			Session ss = sessionFactory.openSession();		
			Query q = ss.createQuery("select max(shippingAddressId) from ShippingAddress");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);		
			id=id+1;
			if(id<=9)
				newSid="SAD0000"+id;
			else if(id<=99)
				newSid="SAD000"+id;
			else if(id<=999)
				newSid="SAD00"+id;
			else if(id<=9999)
				newSid="SAD0"+id;
			else
				newSid="SAD"+id;		
			System.out.print("\nGenerated : "+newSid);		
			ss.close();		
		}
			return newSid;
	}
	@Transactional
		private String generateCartId(){
			String newCartid="";		
			Session s = sessionFactory.openSession();
			Query qr = s.createQuery("from Cart");
			List<Customer> data = qr.list();
			s.close();
			if(data.size()==0){
				newCartid="CRT00001";
			}
			else{
				Session ss = sessionFactory.openSession();		
				Query q = ss.createQuery("select max(cartId) from Cart");
				String prevId = q.list().get(0).toString();
				System.out.print("\nExisting : "+prevId);
				int id = Integer.parseInt(prevId.substring(3));
				System.out.print("\nExisting id : "+id);		
				id=id+1;
				if(id<=9)
					newCartid="CRT0000"+id;
				else if(id<=99)
					newCartid="CRT000"+id;
				else if(id<=999)
					newCartid="CRT00"+id;
				else if(id<=9999)
					newCartid="CRT0"+id;
				else
					newCartid="CRT"+id;		
				System.out.print("\nGenerated : "+newCartid);		
				ss.close();		
			}
				return newCartid;
		}
	
		
	
	
	
		
	@Transactional
		private void saveCustomerImage(Customer cst){
			try{
				if(cst.getImagefile()!=null){
					Path path=Paths.get("E://DBworkspace//cpworld//src//main//webapp//resources//images//users//"+cst.getCustomerId()+".jpg");
					cst.getImagefile().transferTo(new File(path.toString()));
					System.out.println("Image saved");
				}

			}
			catch(Exception excp){
				System.out.println("User Image Not Saved..!!");
			}
		}

	@Transactional
	public Customer getCustomerById(String usrid) {
		Session ses=sessionFactory.openSession();
		System.out.println("before dao");
		Query qr = ses.createQuery("from Customer where userid=?");
		qr.setParameter(0,usrid);
		Customer custdata = (Customer)qr.uniqueResult();
		//Customer custdata=ses.get(Customer.class, usrid);
		ses.flush();
		ses.close();
		System.out.println("afterdao");
		return custdata;
	}

	@Transactional
	public Customer getCustomerByCustomerId(String cstid) {
		Session ses=sessionFactory.openSession();
		Customer data=(Customer)ses.get(Customer.class,cstid);
		ses.close();
		return data;
	}

	@Transactional
	public void updateEditProfileToDB(Customer cust) {
		Session ses=sessionFactory.openSession();
		Transaction tr= ses.beginTransaction();
		cust.getUserdetails().setEnable(true);
		cust.getUserdetails().setRole("ROLE_USER");
		ses.update(cust);
		tr.commit();
		ses.close();	
	}
	
	
		
	

}
