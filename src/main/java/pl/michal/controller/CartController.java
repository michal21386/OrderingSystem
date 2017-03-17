package pl.michal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.michal.dao.Account;
import pl.michal.dao.Cart;
import pl.michal.service.CartService;

@RestController
@RequestMapping("cart")
public class CartController {

	private final CartService cartService;
	
	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@PostMapping
	public void addToCart(@RequestBody Cart cart, @AuthenticationPrincipal Account currentUser) throws Exception{
		cart.setClient(currentUser.getClient());
		cartService.addToCart(cart);
	}
	
	@GetMapping
	public List<Cart> getAll(){
		return cartService.findAll();
	}
	
	
	@PutMapping
	public void changeQuantity(Cart cart) throws Exception{
		cartService.changeQuantity(cart);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) throws Exception {
		cartService.deleteFromCart(id);
	}

	@GetMapping("cos")
	public Map<String, String>cos(){
		Map<String, String> x = new HashMap<>();
		x.put("a", "b");
		x.put("x", "y");
		return x;
	}
}
