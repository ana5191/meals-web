CREATE TABLE
        IF NOT EXISTS area
        (
                id   BIGINT IDENTITY NOT NULL PRIMARY KEY,
                name VARCHAR(100) NOT NULL UNIQUE
        );

CREATE TABLE
        IF NOT EXISTS category
        (
                id          BIGINT IDENTITY NOT NULL PRIMARY KEY,
                name        VARCHAR(100) NOT NULL UNIQUE        ,
                description VARCHAR                             ,
                image_url   VARCHAR(255)
        );

CREATE TABLE
        IF NOT EXISTS ingredient
        (
                id          BIGINT IDENTITY NOT NULL PRIMARY KEY,
                name        VARCHAR(100) NOT NULL UNIQUE        ,
                description VARCHAR                             ,
                i_type      VARCHAR(255)                        , -- `type` is a reserved word in SQL!
                
                -- GENERATED: www.themealdb.com/images/ingredients/{name}.png
                image_url VARCHAR(255) ,
                
                -- GENERATED: www.themealdb.com/images/ingredients/{name}-Small.png
                small_image_url VARCHAR(255)
        );

CREATE TABLE
        IF NOT EXISTS meal
        (
                id           BIGINT IDENTITY NOT NULL PRIMARY KEY ,
                name         VARCHAR(100) NOT NULL UNIQUE         ,
                category_id  BIGINT NOT NULL                      ,
                area_id      BIGINT NOT NULL                      ,
                instructions VARCHAR                              ,
                image_url    VARCHAR(255)                         ,
                
                -- GENERATED: {image_url}/preview
                small_image_url VARCHAR(255)                                   ,
                
                youtube_url     VARCHAR(255)                                   ,
                source_url      VARCHAR(255)                                   ,
                tags            VARCHAR(255)                                   ,
                
                CONSTRAINT fk_area_id FOREIGN KEY (area_id) REFERENCES area(id),            -- ON DELETE CASCADE
                CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES category(id) -- ON DELETE CASCADE
        );

CREATE TABLE
        IF NOT EXISTS meal_composition
        (
                id            BIGINT IDENTITY NOT NULL PRIMARY KEY              ,
                meal_id       BIGINT NOT NULL                                   ,
                ingredient_id BIGINT NOT NULL                                   ,
                measure       VARCHAR(100)                                      ,
                
                -- CONSTRAINT uk_meal_ingredient UNIQUE(meal_id, ingredient_id) ,
                CONSTRAINT fk_meal_id FOREIGN KEY (meal_id) REFERENCES meal(id) ,                 -- ON DELETE CASCADE
                CONSTRAINT fk_ingredient_id FOREIGN KEY (ingredient_id) REFERENCES ingredient(id) -- ON DELETE CASCADE
        );
