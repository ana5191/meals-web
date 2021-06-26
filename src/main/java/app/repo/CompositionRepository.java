package app.repo;

import app.domain.Composition;
import app.domain.projection.CompositionSummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompositionRepository extends JpaRepository<Composition, Long> {
    Iterable<CompositionSummary> findByMealId(Long id);
}
