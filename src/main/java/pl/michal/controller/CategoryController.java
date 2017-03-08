package pl.michal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.michal.dao.Category;
import pl.michal.service.CategoryService;

@RestController
@RequestMapping("category")
public class CategoryController {

	private final CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping("show/{id}")
	public Category showCategory(@PathVariable Long id){
		return categoryService.getCategory(id);
	}
	
	@GetMapping("show")
	public List<Category> showAll(){
		return categoryService.getCategories();
	}
	
}
