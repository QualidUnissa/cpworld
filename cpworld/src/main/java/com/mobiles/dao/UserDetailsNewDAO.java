package com.mobiles.dao;


import java.util.List;

import com.mobiles.model.UserDetailsNew;

public interface UserDetailsNewDAO {
	public UserDetailsNew getUserById(String usrid);
	public List<UserDetailsNew> getUserDetailsList();
	public void disableuser(String ud);
	public void enableuser(String ud);
}
