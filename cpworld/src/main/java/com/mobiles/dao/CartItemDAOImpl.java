package com.mobiles.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mobiles.model.Cart;
import com.mobiles.model.CartItem;
import com.mobiles.model.Customer;
@Repository
public class CartItemDAOImpl implements CartItemDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	public void addCartItem(CartItem cartitem) {
		Session ses=sessionFactory.openSession();
		cartitem.setCartitemId(generateCartItemId());
		ses.save(cartitem);
		ses.flush();
		ses.close();
		
	}
	
	
	
	
	
	@Transactional
	public void removeItemfromCart(String crmid) {
		Session ses=sessionFactory.openSession();
		CartItem data=ses.get(CartItem.class,crmid);
		ses.delete(data);
		ses.flush();
		ses.close();
		
	}
	@Transactional
	public void clearCart(String cstmrid) {
	Session ses= sessionFactory.openSession();
	Customer customer=ses.get(Customer.class, cstmrid);
	Cart crt=customer.getCart();
	List<CartItem> cartitems=crt.getCartItems();
	for(CartItem data:cartitems){
		removeItemfromCart(data.getCartitemId());
	}
	}




	@Transactional
	private String generateCartItemId(){
		String newCartItemid="";		
		Session s = sessionFactory.openSession();
		Query qr = s.createQuery("from CartItem");
		List<Customer> data = qr.list();
		s.close();
		if(data.size()==0){
			newCartItemid="CTM00001";
		}
		else{
			Session ss = sessionFactory.openSession();		
			Query q = ss.createQuery("select max(cartitemId) from CartItem");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);		
			id=id+1;
			if(id<=9)
				newCartItemid="CTM0000"+id;
			else if(id<=99)
				newCartItemid="CTM000"+id;
			else if(id<=999)
				newCartItemid="CTM00"+id;
			else if(id<=9999)
				newCartItemid="CTM0"+id;
			else
				newCartItemid="CRT"+id;		
			System.out.print("\nGenerated : "+newCartItemid);		
			ss.close();		
		}
			return newCartItemid;
	}






	

}
