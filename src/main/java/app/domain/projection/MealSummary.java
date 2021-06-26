package app.domain.projection;

/**
 * Pt cazul cind NU vrem sa extragem toate informatiile despre un Meal, ci numai o parte!
 * In loc de entity, vom folosi o PROJECTION cu un set redus de atribute.
 * Util pt get-meals-by-category, sau get-meals-by-area
 * 
 * READ-ONLY! Deci vom scrie GETTERS in interfata.
 * Spring Data va crea automat o clasa (la fel ca pt interfetele repository!).
 * 
 * https://www.baeldung.com/spring-data-jpa-projections
 * https://thorben-janssen.com/dto-projections
 * https://thorben-janssen.com/entities-dtos-use-projection
 * 
 */
public interface MealSummary {
	// Declaram aici doar acei GETTERs din @Entity Meal - pt care ne intereseaza atributele:
	Long getId();
	String getName();
//	String getImageUrl();		// asta e prea mare, are 700 x 700 ==> browserul incarca greu o lista de imagini
	String getSmallImageUrl();	// asta e cam mica pt UI, are doar 150 x 150...
}
