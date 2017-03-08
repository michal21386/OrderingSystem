package pl.michal.service;

import java.util.List;

import pl.michal.dao.Products;

public interface ProductService {

	Products getProduct(Long id);
	List<Products> searchProductsByName(String name);
	List<Products> searchProductsByDescription(String description);
	List<Products> getProductsByCategory(Long id);	
}
