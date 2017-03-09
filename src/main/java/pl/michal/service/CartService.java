package pl.michal.service;

import java.util.List;

import pl.michal.dao.Cart;

public interface CartService {

	void addToCart(Cart cart) throws Exception;
	void changeQuantity(Cart cart) throws Exception;
	List<Cart> findAll();
	void deleteFromCart(Long id) throws Exception;
	
}
