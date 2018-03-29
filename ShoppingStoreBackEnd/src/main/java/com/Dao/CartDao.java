package com.Dao;

import java.util.List;

import javax.persistence.Id;

import com.domain.Cart;

public interface CartDao {
	@Id
	
	public boolean save(Cart cart);
	

	
	public boolean update(Cart cart);
	

	
	public Cart get(String id);
	
	
	
	public boolean delete(String id);
// to get all the carts added by a particular user
	public List<Cart> list(String emailID);
}
