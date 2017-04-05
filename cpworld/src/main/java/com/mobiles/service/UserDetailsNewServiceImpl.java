package com.mobiles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobiles.dao.UserDetailsNewDAO;
import com.mobiles.model.UserDetailsNew;
@Service
public class UserDetailsNewServiceImpl implements UserDetailsNewService {
	
	@Autowired
	private UserDetailsNewDAO userdetailsDao;


	public UserDetailsNew getUserById(String usrid) {
		return userdetailsDao.getUserById(usrid);
	}

	
	public List<UserDetailsNew> getUserDetailsList() {
		return userdetailsDao.getUserDetailsList();
	}


	public void disableuser(String ud) {
		userdetailsDao.disableuser(ud);
	}


	public void enableuser(String ud) {
		userdetailsDao.enableuser(ud);
		
	}
	
	

}
