package com.mobiles.dao;

import java.util.List;


import com.mobiles.model.Suppliers;

public interface SupplierDAO {
	public abstract void addSuppliers(Suppliers sp);
	public abstract List<Suppliers> displaySuppliers();
	public Suppliers getSupplierById(String sid); 
	public abstract void updateSupliers(Suppliers sup);
	public abstract void deleteSupliers(String sup);

}
