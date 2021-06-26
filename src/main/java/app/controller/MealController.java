package app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.domain.Meal;
import app.domain.projection.MealSummary;
import app.repo.MealRepository;

@RestController
@RequestMapping("/meals")
public class MealController {

	@Autowired
	MealRepository mealRepository;

	@GetMapping
	Iterable<Meal> getAllMeals() {
		return mealRepository.findAll();
	}


	@GetMapping(path = "/{id}")
	Optional<Meal> getMealById(@PathVariable Long id) {
		return mealRepository.findById(id);
	}

	

	@GetMapping("/category")
	Iterable<MealSummary> getMealsByCategoryId(@RequestParam(name="id") Long idCategory) {
		return mealRepository.findByCategoryId(idCategory);
	}
	

	@GetMapping("area")
	Iterable<MealSummary> getMealsByAreaId(@RequestParam(name="id") Long idArea) {
		return mealRepository.findByAreaId(idArea);
	}

}
