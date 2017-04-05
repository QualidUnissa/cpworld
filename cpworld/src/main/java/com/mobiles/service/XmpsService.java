package com.mobiles.service;

import java.util.List;

import com.mobiles.model.XMAP_Product_Supplier;

public interface XmpsService {
	public abstract void addXmps(XMAP_Product_Supplier xmps);
	 public abstract List<XMAP_Product_Supplier> displayXmps();
	 public void deleteProductSupliers(String psd);
	 public XMAP_Product_Supplier getProductSupliersById(String psd);
	 public void updateProductSupplierstoDB(XMAP_Product_Supplier psd);
}
