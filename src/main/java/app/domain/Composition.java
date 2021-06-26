package app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "meal_composition" // vezi schema.sql
		//, uniqueConstraints={@UniqueConstraint(columnNames ={"meal_id","ingredient_id"})}
)
public class Composition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY) // @ManyToOne unidirectional
	@JoinColumn(name = "ingredient_id") // vezi schema.sql: FK MEAL_COMPOSITION.ingredient_id --> PK INGREDIENT.id
	private Ingredient ingredient;

	public Long getMealId() {
		return mealId;
	}

	public void setMealId(Long mealId) {
		this.mealId = mealId;
	}

	@Column(name="meal_id")
     private Long mealId;

	@Column(length = 100) // vezi schema.sql
	private String measure;

	/*
	 * GETTERS & SETTERS
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	/*
	 * equals & hashCode -- doar cind folosim clasa asta in Set; sau key in Map
	 */
/*
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Composition other = (Composition) obj;
		return Objects.equals(id, other.id);
	}
*/
}
