package pl.michal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.michal.dao.Category;
import pl.michal.repository.CategoryRepository;

@Service
public class CategoryServiceBean implements CategoryService{

	private final CategoryRepository categoryRepository;

	@Autowired
	public CategoryServiceBean(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category getCategory(Long id) {
		return categoryRepository.findOne(id);
	}

	@Override
	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}
	
	
}
