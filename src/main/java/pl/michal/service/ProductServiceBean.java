package pl.michal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.michal.dao.Products;
import pl.michal.repository.ProductRepository;

@Service
public class ProductServiceBean implements ProductService {

	private final ProductRepository productRepository;
	
	@Autowired
	public ProductServiceBean(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Products getProduct(Long id) {
		return productRepository.findOne(id);
	}

	@Override
	public List<Products> searchProductsByName(String name) {
		return productRepository.findByNameContaining(name);
	}

	@Override
	public List<Products> searchProductsByDescription(String description) {
		return productRepository.findByDescriptionContaining(description);
	}

	@Override
	public List<Products> getProductsByCategory(Long id) {
		return productRepository.findByIdCategory(id);
	}

}
