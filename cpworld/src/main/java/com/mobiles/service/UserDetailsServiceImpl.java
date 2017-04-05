package com.mobiles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobiles.dao.UserDetailsDAO;
import com.mobiles.model.UserDetails;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
@Autowired
private UserDetailsDAO userdetails;
	public String addUser(UserDetails ud) {
		System.out.println("before SErvice");
		return userdetails.addUser(ud);
	}
	public UserDetails loginCheck(UserDetails ud){
		return userdetails.loginCheck(ud);
	}
	public UserDetails getUserById(String usrid){
		return userdetails.getUserById(usrid);
	}
	public void editProfileToDB(UserDetails usrd) {
		userdetails.editProfileToDB(usrd);
		
	}
	public List<UserDetails> getUserDetailsList() {
		return userdetails.getUserDetailsList();
	}
	public void disableuser(String ud) {
		userdetails.disableuser(ud);
		
	}
	public void enableuser(String ud) {
		userdetails.enableuser(ud);
	}
	
	
	
	
	

}
