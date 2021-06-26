package app.domain.projection;

import app.domain.Ingredient;

public interface CompositionSummary {
    Long getMealId();
    Ingredient getIngredient();
    String getMeasure();

}
