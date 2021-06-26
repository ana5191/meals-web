package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.domain.Category;
import app.repo.CategoryRepository;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping
	Iterable<Category> getAll() {
		return categoryRepository.findAll();
	}
}
