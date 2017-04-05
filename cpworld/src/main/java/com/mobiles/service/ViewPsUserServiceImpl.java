package com.mobiles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobiles.dao.ViewPsUserDAO;
import com.mobiles.model.ViewXmapPS;
@Service
public class ViewPsUserServiceImpl implements ViewPsUserService {
@Autowired
private ViewPsUserDAO viewPsDao;
	public List<ViewXmapPS> displayproductsUser() {
	
		return viewPsDao.displayproductsUser();
	}
	public List<ViewXmapPS> getBestViewProducts(){
		return viewPsDao.getBestViewProducts();
	}
	public List<ViewXmapPS> getAllSupplierProducts(String pid) {
		
		return viewPsDao.getAllSupplierProducts(pid);
	}

}
