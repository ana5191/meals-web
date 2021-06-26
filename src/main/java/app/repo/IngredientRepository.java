package app.repo;

import app.asbtractization.ReadOnlyRepository;
import app.domain.Ingredient;

public interface IngredientRepository extends ReadOnlyRepository<Ingredient, Long> {
}
