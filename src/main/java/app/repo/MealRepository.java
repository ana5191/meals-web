package app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import app.domain.Meal;
import app.domain.projection.MealSummary;


public interface MealRepository extends JpaRepository<Meal, Long> {
	

	Iterable<MealSummary> findByCategoryId(Long id);
	Iterable<MealSummary> findByAreaId(Long id);

}
