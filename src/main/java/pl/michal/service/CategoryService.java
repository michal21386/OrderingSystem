package pl.michal.service;

import java.util.List;

import pl.michal.dao.Category;

public interface CategoryService {

	Category getCategory(Long id);
	List<Category> getCategories();
}
