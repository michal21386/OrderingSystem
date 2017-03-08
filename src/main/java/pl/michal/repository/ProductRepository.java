package pl.michal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.michal.dao.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {
	
	public List<Products> findByNameContaining(String contains);
	public List<Products> findByDescriptionContaining(String contains);
	@Query("select p from Products p where p.category.id=?1")
	public List<Products> findByIdCategory(Long id);
	
	
}
