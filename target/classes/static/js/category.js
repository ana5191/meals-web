/**
 * Scripts for area.html
 */
const BASE_URL = 'http://localhost:9090';
const CATEGORY_LIST_URL = BASE_URL + '/categories';
const COMPOSITION_LIST_URL = BASE_URL + '/composition/meals/meal?id=';
const MEAL_LIST_BY_CATEGORY_URL = BASE_URL + '/meals/category?id='; //+areaId
const MEAL_BY_ID = BASE_URL + '/meals/'; //+mealId

const categoryListContainer = document.getElementById('category_list_container');
const currentCategoryNameContainer = document.getElementById('current_category_name_container');
const mealListContainer = document.getElementById('meal_list_container');
const ingredientListContainer = document.getElementById('ingredient_list_container');
//const measureListContainer = document.getElementById('measure_name_container');

/**
 * GET http://localhost:9090/categories
 */
const loadCategoryList = function () {
    fetch(CATEGORY_LIST_URL)
        .then(res => res.json())
        .then(data => renderCategoryList(data))
        .catch(err => console.log("Error:", err));
};

const renderCategoryList = function (categoryList) {
    let content = '';
    for (let i = 0; i < categoryList.length; i++) {
        const category = categoryList[i];
        content += `<div class="w3-center w3-padding-small w3-quarter">`;
        content += `<a class="w3-button w3-hover-orange w3-xlarge" href="javascript:void(0);"`;
        content += ` onClick="loadMealsByCategory('${category.id}', '${category.name}')">`;
        content += `${category.name}</a>`;
        content += `</div>`;
    }
    categoryListContainer.innerHTML = content;
};


/**
 * GET http://localhost:9090/meals/category?id={categoryId}
 */
const loadMealsByCategory = function (categoryId, categoryName) {
    fetch(MEAL_LIST_BY_CATEGORY_URL + categoryId)
        .then(res => res.json())
        .then(data => renderMealList(data, categoryName))
        .catch(err => console.log("Error:", err));
};

const renderMealList = function (mealList, categoryName) {
    currentCategoryNameContainer.innerHTML = categoryName;

    let content = '';
    for (let i = 0; i < mealList.length; i++) {
        const meal = mealList[i];
        content += `<div class="w3-center w3-padding-16 w3-third w3-bar">`;
        content += `<img class="w3-round w3-image w3-card-4 w3-opacity-min w3-hover-opacity-off" style="cursor:pointer"`;
        content += ` width="240" onClick="loadMeal('${meal.id}')" src="${meal.smallImageUrl}" />`;
        content += `<br />`;
        content += `<span class="tooltip">`;
        // content += `<span class="w3-large tooltiptext">${meal.name}</span>`;
        content += `<a class="w3-button w3-hover-orange w3-large" href="javascript:void(0);"`;
        content += ` onClick="loadMeal('${meal.id}')">`;
        content += `${meal.name.length < 22 ? meal.name : meal.name.substring(0, 19).concat('...')}`;
        content += `</a>`;
        content += `</span>`;
        content += `</div>`;
    }
    mealListContainer.innerHTML = content;
};


/**
 * GET http://localhost:9090/meals/{mealId}
 */
const loadMeal = function (mealId) {
    fetch(MEAL_BY_ID + mealId)
        .then(res => res.json())
        .then(data => renderMeal(data))
        .catch(err => console.log("Error:", err));
};


const renderMeal = function (meal) {

    document.getElementById("meal_img").src = meal.imageUrl;
    document.getElementById("meal_title").innerHTML = meal.name;
    document.getElementById("meal_subtitle").innerHTML = meal.category.name + '  &nbsp;|&nbsp;   ' + meal.area.name + ' area';
    document.getElementById("meal_instructions").innerHTML = meal.instructions;

    let compositionList = `<ul>`;
    meal.compositions.forEach(elem => compositionList += `<li>${elem.measure} x ${elem.ingredient.name}</li>`);
    compositionList += `</ul>`;

    document.getElementById("meal_composition").innerHTML = compositionList;
    document.getElementById("meal_container").style.display = "block";
};
