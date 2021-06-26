package app.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Meal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true, length = 100) // vezi schema.sql
	private String name;

	@ManyToOne(fetch = FetchType.LAZY) // @ManyToOne unidirectional
	@JoinColumn(name = "category_id") // vezi schema.sql: FK MEAL.category_id --> PK CATEGORY.id
	private Category category;

	@ManyToOne(fetch = FetchType.LAZY) // @ManyToOne unidirectional
	@JoinColumn(name = "area_id") // vezi schema.sql: FK MEAL.area_id --> PK AREA.id
	private Area area;

	
	@OneToMany(fetch = FetchType.EAGER) // @OneToMany unidirectional; join column (FK) este in celalata @Entity!
	@JoinColumn(name = "meal_id") // vezi schema.sql: PK MEAL.id <-- FK MEAL_COMPOSITION.meal_id
	private List<Composition> compositions; // IN GENERAL: Mai bine Set<T> decit List<T>;
											// caz in care trebuie definite equals+hashCode in Composition!

	private String instructions;

	@Column(name = "image_url") // vezi schema.sql
	private String imageUrl;

	// GENERATED: {image_url}/preview
	@Column(name = "small_image_url") // vezi schema.sql
	private String smallImageUrl;

	@Column(name = "youtube_url") // vezi schema.sql
	private String youtubeUrl;

	@Column(name = "source_url") // vezi schema.sql
	private String sourceUrl;

	private String tags;

	/*
	 * GETTERS & SETTERS
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<Composition> getCompositions() {
		return compositions;
	}

	public void setCompositions(List<Composition> compositions) {
		this.compositions = compositions;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getSmallImageUrl() {
		return smallImageUrl;
	}

	public void setSmallImageUrl(String smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
	}

	public String getYoutubeUrl() {
		return youtubeUrl;
	}

	public void setYoutubeUrl(String youtubeUrl) {
		this.youtubeUrl = youtubeUrl;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
}
