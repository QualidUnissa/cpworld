package com.mobiles.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mobiles.model.UserDetails;
import com.mobiles.model.UserDetailsNew;
@Repository
public class UserDetailsNewDAOImpl implements UserDetailsNewDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public UserDetailsNew getUserById(String usrid) {
			Session ses=sessionFactory.openSession();
			UserDetailsNew user= (UserDetailsNew)ses.get(UserDetailsNew.class,usrid);
			ses.close();
			return user;
	}
	
	@Transactional
	public List<UserDetailsNew> getUserDetailsList() {
		Session ss=sessionFactory.openSession();
		Query qr= ss.createQuery("from UserDetailsNew");
		List<UserDetailsNew> data=qr.list();
		ss.close();
		return data;
	}
	public void disableuser(String ud) {
		Session ses= sessionFactory.openSession();
		UserDetailsNew data=ses.get(UserDetailsNew.class,ud);
		data.setEnable(false);
		ses.update(data);
		ses.flush();
		ses.close();
	}
	public void enableuser(String ud) {
		Session ses= sessionFactory.openSession();
		UserDetailsNew data=ses.get(UserDetailsNew.class,ud);
		data.setEnable(true);
		ses.update(data);
		ses.flush();
		ses.close();
	}


}
