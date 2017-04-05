package com.mobiles.dao;

import java.util.List;

import com.mobiles.model.UserDetails;

public interface UserDetailsDAO {
	public String addUser(UserDetails ud);
	public UserDetails loginCheck(UserDetails ud);
	public UserDetails getUserById(String usrid);
	public void editProfileToDB(UserDetails usrd);
	public abstract List<UserDetails> getUserDetailsList();
	public abstract void disableuser(String ud);
	public abstract void enableuser(String ud);
}
