package pl.michal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.michal.dao.Products;
import pl.michal.service.ProductService;

@RequestMapping("product")
@RestController
public class ProductController {
	
	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("show/{id}")
	public Products showProduct(Long id){
		return productService.getProduct(id);
	}
	
	@GetMapping("find/name/{name}")
	public List<Products> searchByName(String name){
		return productService.searchProductsByName(name);
	}
	
	@GetMapping("find/desc/{desc}")
	public List<Products> searchByDescription(String desc){
		return productService.searchProductsByDescription(desc);
	}
	
	@GetMapping("show/category/{id}")
	public List<Products> showByCategory(Long id){
		return productService.getProductsByCategory(id);
	}
	
}
