package com.mobiles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobiles.dao.XmpsDAO;
import com.mobiles.model.XMAP_Product_Supplier;
@Service
public class XmpsServiceImpl implements XmpsService {
@Autowired
private XmpsDAO xmpsdao;
	public void addXmps(XMAP_Product_Supplier xmps) {
		xmpsdao.addXmps(xmps);

	}

	public List<XMAP_Product_Supplier> displayXmps() {
		return xmpsdao.displayXmps();
	}

	public void deleteProductSupliers(String psd) {
		xmpsdao.deleteProductSupliers(psd);
	}

	public XMAP_Product_Supplier getProductSupliersById(String psd) {
	
		return xmpsdao.getProductSupliersById(psd);
	}
	
	 public void updateProductSupplierstoDB(XMAP_Product_Supplier psd){
		xmpsdao.updateProductSupplierstoDB(psd);
	 }
	

}
