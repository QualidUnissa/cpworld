package com.mobiles.service;

import java.util.List;

import com.mobiles.model.ViewXmapPS;

public interface ViewPsUserService {
	 public List<ViewXmapPS> displayproductsUser();
	 public List<ViewXmapPS> getBestViewProducts();
	 public List<ViewXmapPS> getAllSupplierProducts(String pid);
}
