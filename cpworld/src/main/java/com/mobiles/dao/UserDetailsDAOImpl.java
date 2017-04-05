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

import com.mobiles.model.Suppliers;
import com.mobiles.model.UserDetails;
@Repository
public class UserDetailsDAOImpl implements UserDetailsDAO {
@Autowired
private SessionFactory sf;
@Transactional
	public String addUser(UserDetails ud) {
		System.out.println("before dao");
		
		Session ses=sf.openSession();
		Transaction tr= ses.beginTransaction();
		ud.setUserid(generateUserId());
		ud.setRole("ROLE_USER");
		ud.setIsenabled(true);
		ses.save(ud);
		saveUserImage(ud);
		tr.commit();
		ses.close();
		System.out.println("after dao");
		return ud.getUserid();
	}
	@Transactional
	private String generateUserId(){	
		
		String newUid="";
		
		Session s = sf.openSession();
		Query qr = s.createQuery("from UserDetails");
		List<UserDetails> data = qr.list();
		s.close();
		if(data.size()==0){
			newUid="USR00001";
		}
		else {			
			Session ss = sf.openSession();		
			Query q = ss.createQuery("select max(userid) from UserDetails");
			String prevId = q.list().get(0).toString();
			System.out.println(prevId);
			
			/*Query q = ss.createQuery("select max(userid) from UserDetails");
			String temp = (String)q.uniqueResult();
			System.out.println(temp);*/
			
			
			//Query q = ss.createQuery("from UserDetails where userid='USR00001'");
			//q.list(); // returns many rec
			//UserDetails ud = (UserDetails)q.uniqueResult();
			//System.out.println(ud +  " : "+ ud.getUserid())e;
			
			//String prevId = q.list().get(0).toString();
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
	public UserDetails loginCheck(UserDetails ud){
		Session ses= sf.openSession();
		
		Query qr=ses.createQuery("from UserDetails where userid=? and password=? and isenabled=true");
		qr.setParameter(0,ud.getUserid());
		qr.setParameter(1,ud.getPassword());
		//qr.list(); //returns multiple records
		UserDetails t=(UserDetails)qr.uniqueResult();//returns single record
		
		return t;
	}
	@Transactional
	private void saveUserImage(UserDetails ud){
		System.out.print("\nprd img : " + ud.getImagefile());	
		try{
			if(ud.getImagefile()!=null){
				Path path=Paths.get("E://DBworkspace//cpworld//src//main//webapp//resources//images//users//"+ud.getUserid()+".jpg");
				ud.getImagefile().transferTo(new File(path.toString()));
				System.out.print("\nProduct Image saved");	
			}
		}
		catch(Exception e){
			System.out.print("\nProduct Image not saved...");
		}
		
	}
	
	@Transactional
	public UserDetails getUserById(String usrid){
		Session ses=sf.openSession();
		UserDetails user= (UserDetails)ses.get(UserDetails.class,usrid);
		ses.close();
		return user;
	}
	@Transactional
	public void editProfileToDB(UserDetails usrd) {
		Session ses=sf.openSession();
		Transaction tr=ses.beginTransaction();
		usrd.setIsenabled(true);
		usrd.setRole("ROLE_USER");
		ses.update(usrd);
		tr.commit();
		ses.close();
		
	}
	
	@Transactional
	public List<UserDetails> getUserDetailsList() {
		Session ss=sf.openSession();
		Query qr= ss.createQuery("from UserDetails");
		List<UserDetails> data=qr.list();
		ss.close();
		return data;
	}
	public void disableuser(String ud) {
		Session ses= sf.openSession();
		UserDetails data=ses.get(UserDetails.class,ud);
		data.setIsenabled(false);
		ses.update(data);
		ses.flush();
		ses.close();
	}
	public void enableuser(String ud) {
		Session ses= sf.openSession();
		UserDetails data=ses.get(UserDetails.class,ud);
		data.setIsenabled(true);
		ses.update(data);
		ses.flush();
		ses.close();
	}

	
	
	
	
	
}
