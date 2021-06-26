package app.controller;

import app.domain.Composition;
import app.domain.Meal;
import app.domain.projection.CompositionSummary;
import app.domain.projection.MealSummary;
import app.repo.CompositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    @RequestMapping("composition")
    public class CompositionController {

        @Autowired
        CompositionRepository compositionRepository;

        @GetMapping("/meal")
        Iterable<CompositionSummary> getMealsByMealsId(@RequestParam(name="id") Long idmeal) {
            return compositionRepository.findByMealId(idmeal);
        }
    }

