package app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import app.domain.Meal;
import app.domain.projection.MealSummary;

/**
 * IS-A JpaRepository ==> full support: CRUD, pagination, batch, QBE
 * 
 * Repository <-- CrudRepository <-- PagingAndSortingRepository <-- JpaRepository
 * 
 * CrudRepository:				adds support for CRUD operations: exists/count/find, save, delete
 * PagingAndSortingRepository:	adds: Iterable<T> findAll(Sort sort), Page<T> findAll(Pageable pageable)
 * JpaRepository:				adds support for batch operations and QBE (Query By Example)
 * 
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.named-queries
 */
public interface MealRepository extends JpaRepository<Meal, Long> {
	
	/*
	 * @Query("select m from Meal m where m.category.id = ?1")
	 */
//	Iterable<Meal> findByCategoryId(Long id);
	
	/*
	 * @Query("select m from Meal m where m.area.id = ?1")
	 */
//	Iterable<Meal> findByAreaId(Long id);
	
	
	/*
	 * Variantele cu MealSummary PROJECTION, ca sa extragem mai putine date:
	 * 1) doar o parte din atributele entitatii
	 * 2) fara referinte catre celelalte entities!
	 */
	Iterable<MealSummary> findByCategoryId(Long id);
	Iterable<MealSummary> findByAreaId(Long id);

}
