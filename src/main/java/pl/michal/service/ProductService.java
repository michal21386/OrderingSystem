package pl.michal.service;

import java.util.List;

import pl.michal.dao.Products;

public interface ProductService {

	Products getProduct(Long id);
	List<Products> getProductsByName(String name);
	List<Products> getProductsByCategory(String name);	
}
