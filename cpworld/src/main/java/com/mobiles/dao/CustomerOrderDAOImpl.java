package com.mobiles.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobiles.model.Cart;
import com.mobiles.model.CartItem;
import com.mobiles.model.CustomerOrder;
import com.mobiles.model.CustomerOrderHistory;
@Repository
public class CustomerOrderDAOImpl implements CustomerOrderDAO {
	@Autowired
	private SessionFactory sessionfactory;

	
	
	
	
	public void addOrder(Cart crt) {
		CustomerOrder custOrderObj= new CustomerOrder();
		custOrderObj.setOrderId(generateCustomerOrderId());
		custOrderObj.setCart(crt);
		custOrderObj.setCustomer(crt.getCustomer());
		custOrderObj.setBillingAddress(crt.getCustomer().getBillingAddress());
		custOrderObj.setShippingAddress(crt.getCustomer().getShippingAddress());
		Session ses=sessionfactory.openSession();
		ses.save(custOrderObj);
		ses.flush();
		ses.close();
		
		
		
		
		
		//To update graandtotal in cart table
		
		List<CartItem> cartitems=crt.getCartItems();
		
		Session session= sessionfactory.openSession();
		for(CartItem data:cartitems){
			CustomerOrderHistory history=new CustomerOrderHistory();
			history.setOrderhistoryId(generateOrderHistoryId());
			history.setCustomerOrder(custOrderObj);
			history.setPrice(data.getXmapPS().getProductsupplierprice());
			history.setQuantity(data.getQuantity());
			history.setProductid(data.getXmapPS().getProductid());
			history.setReviewgiven(false);
			history.setSupplierid(data.getXmapPS().getSupplierid());
			history.setTotal(data.getItemwisetotal());
			session.save(history);
			session.flush();
		}
		session.close();

	}


	private String generateCustomerOrderId(){
		
		String newOid="";
		
		Session s = sessionfactory.openSession();
		Query qr = s.createQuery("from CustomerOrder");
		List<CustomerOrder> data = qr.list();
		s.close();
		if(data.size()==0){
			newOid="ORD00001";
		}
		else{
			Session ss = sessionfactory.openSession();		
			Query q = ss.createQuery("select max(orderId) from CustomerOrder");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);		
			id=id+1;
			if(id<=9)
				newOid="ORD0000"+id;
			else if(id<=99)
				newOid="ORD000"+id;
			else if(id<=999)
				newOid="ORD00"+id;
			else if(id<=9999)
				newOid="ORD0"+id;
			else
				newOid="ORD"+id;		
			System.out.print("\nGenerated : "+newOid);		
			ss.close();		
		}
			return newOid;
	}
	
	
private String generateOrderHistoryId(){
		
		String newOHid="";
		
		Session s = sessionfactory.openSession();
		Query qr = s.createQuery("from CustomerOrderHistory");
		List<CustomerOrderHistory> data = qr.list();
		s.close();
		if(data.size()==0){
			newOHid="ORDH00001";
		}
		else{
			Session ss = sessionfactory.openSession();		
			Query q = ss.createQuery("select max(orderhistoryId) from CustomerOrderHistory");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(4));
			System.out.print("\nExisting id : "+id);		
			id=id+1;
			if(id<=9)
				newOHid="ORDH0000"+id;
			else if(id<=99)
				newOHid="ORDH000"+id;
			else if(id<=999)
				newOHid="ORDH00"+id;
			else if(id<=9999)
				newOHid="ORDH0"+id;
			else
				newOHid="ORDH"+id;		
			System.out.print("\nGenerated : "+newOHid);		
			ss.close();		
		}
			return newOHid;
	}


}
