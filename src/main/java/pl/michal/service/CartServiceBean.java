package pl.michal.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.michal.dao.Cart;
import pl.michal.repository.CartRepository;

@Service
public class CartServiceBean implements CartService {

	private final CartRepository cartRepository; 
	
	@Autowired
	public CartServiceBean(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}

	@Override
	public void addToCart(Cart cart) throws Exception{
		if(cart!=null){
			if(cart.getProduct()==null) throw new NullPointerException("Brak produktu!");
			if(cart.getQuantity()>0) cartRepository.save(cart);
		}
	}

	@Transactional
	@Override
	public void changeQuantity(Cart cart) throws Exception {
		if(cart!=null){
			if (cart.getId() != null) throw new NullPointerException("poza");
			if(cart.getQuantity()<=0) cartRepository.delete(cart.getId());
			else {
				Cart cartEntity = cartRepository.findOne(cart.getId());
				cartEntity.setQuantity(cart.getQuantity());
			}
		}
	}

	@Override
	public List<Cart> findAll() {
		return cartRepository.findAllByAuthenticatedClient();
	}
	
	@Transactional
	@Override
	public void deleteFromCart(Long id) throws Exception{
		cartRepository.deleteFromCartByAuthenticatedUser(id);
	}

}
