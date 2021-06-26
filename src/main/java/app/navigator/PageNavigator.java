package app.navigator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * Spring MVC!
 * NO @RestController
 * NO @ResponseBody
 */
@Controller
public class PageNavigator {
	private static final String PARAM_HOME = "home";
	private static final String PARAM_AREA = "area";
	private static final String PARAM_CATEGORY = "category";

	private static final String VIEW_NAME_HOME = "forward:index.html";		// in src/main/resources/static
	private static final String VIEW_NAME_AREA = "forward:html/area.html";	// in src/main/resources/static/html
	private static final String VIEW_NAME_CATEGORY = "forward:html/category.html";

	/**
	 * ! NOT @ResponseBody
	 * See area.html:
	 * <a href="/?page=category" ...>Category</a>
	 */
	@GetMapping
	public String navigate(@RequestParam(name = "page", defaultValue = PARAM_HOME) String page) {
		switch (page) {

		case PARAM_AREA:
			return VIEW_NAME_AREA;

		case PARAM_CATEGORY:
			return VIEW_NAME_CATEGORY;

		default:
			return VIEW_NAME_HOME;
		}
	}
}
