package com.mobiles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobiles.dao.SupplierDAO;
import com.mobiles.model.Suppliers;
@Service
public class SupplierServiceImpl implements SupplierService {
	@Autowired
	private SupplierDAO supplierdao;
	public  void addSuppliers(Suppliers sp){
		supplierdao.addSuppliers(sp);
	}
	
	public List<Suppliers> displaySuppliers(){
		return supplierdao.displaySuppliers();
	}
	public Suppliers getSupplierById(String sid) {
				return supplierdao.getSupplierById(sid);
	}

	public void updateSupliers(Suppliers sup) {
	supplierdao.updateSupliers(sup);
	}

	public void deleteSupliers(String sup) {
		supplierdao.deleteSupliers(sup);
		
	}
	
}
