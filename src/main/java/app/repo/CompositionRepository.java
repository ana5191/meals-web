package app.repo;

import app.asbtractization.ReadOnlyRepository;

import app.domain.Composition;
import app.domain.Meal;
import app.domain.projection.CompositionSummary;
import app.domain.projection.MealSummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompositionRepository extends JpaRepository<Composition, Long> {
    Iterable<CompositionSummary> findByMealId(Long id);
}
