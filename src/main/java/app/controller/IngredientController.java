package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.domain.Ingredient;
import app.repo.IngredientRepository;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

	@Autowired
	IngredientRepository ingredientRepository;

	@GetMapping
	Iterable<Ingredient> getAll() {
		return ingredientRepository.findAll();
	}
}
