package com.mobiles.dao;

import java.util.List;

import com.mobiles.model.ViewXmapPS;

public interface ViewPsUserDAO {
 public List<ViewXmapPS> displayproductsUser();
 public List<ViewXmapPS> getBestViewProducts();
 public List<ViewXmapPS> getAllSupplierProducts(String pid);
}
