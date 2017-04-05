package com.mobiles.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mobiles.model.Cart;
import com.mobiles.model.CartItem;
@Repository
public class CartDAOImpl implements CartDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional 
	public Cart getCart(String crtid) {
		Session ses= sessionFactory.openSession();
		Cart data=ses.get(Cart.class,crtid);
		ses.close();
		return data;
	}

	@Transactional
	public int sizeOfCart(Cart cart) {
		List<CartItem> data=cart.getCartItems();
		return data.size();
	}

	@Transactional
	public void updateItemsToCart(Cart crt) {
		Session ss= sessionFactory.openSession();
		ss.update(crt);
		ss.flush();
		ss.close();
		
	}
	public Cart validate(String cartid) throws IOException{
		Cart cart= getCart(cartid);
		if(cart==null||cart.getCartItems().size()==0){
			throw new IOException(cartid+"");
		}
		//updateItemsToCart(cart);
		return cart;
	}
	

}
