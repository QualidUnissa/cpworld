package com.mobiles.service;

import java.util.List;

import com.mobiles.model.UserDetailsNew;

public interface UserDetailsNewService {
	public UserDetailsNew getUserById(String usrid);
	public List<UserDetailsNew> getUserDetailsList();
	public void disableuser(String ud);
	public void enableuser(String ud);
}
