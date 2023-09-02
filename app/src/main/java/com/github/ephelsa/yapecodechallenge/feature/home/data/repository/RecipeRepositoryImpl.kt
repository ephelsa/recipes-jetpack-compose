package com.github.ephelsa.yapecodechallenge.feature.home.data.repository

import com.github.ephelsa.yapecodechallenge.feature.home.data.model.Recipe
import kotlinx.coroutines.delay

internal class RecipeRepositoryImpl : RecipeRepository {
    override suspend fun fetchRecipesList(): Result<List<Recipe>> {
        delay(2_000)

        return Result.success(
            listOf(
                Recipe(
                    id = "1",
                    name = "Banana Banana Bread",
                    imagePath = "https://www.allrecipes.com/thmb/8QzNWDvGhdry6V1jnyJWIhKA_nk=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/20144-banana-banana-bread-mfs-57-0bb49d050a6941c4b3715e57b8e6badd.jpg",
                    ingredients = listOf(
                        "Flour",
                        "Baking Soda",
                        "Salt",
                        "Butter",
                        "Brown Sugar",
                        "Eggs",
                        "Bananas"
                    ),
                ),
                Recipe(
                    id = "1",
                    name = "Banana Banana Bread",
                    imagePath = "https://www.allrecipes.com/thmb/8QzNWDvGhdry6V1jnyJWIhKA_nk=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/20144-banana-banana-bread-mfs-57-0bb49d050a6941c4b3715e57b8e6badd.jpg",
                    ingredients = listOf(
                        "Flour",
                        "Baking Soda",
                        "Salt",
                        "Butter",
                        "Brown Sugar",
                        "Eggs",
                        "Bananas"
                    ),
                ),
                Recipe(
                    id = "1",
                    name = "Banana Banana Bread",
                    imagePath = "https://www.allrecipes.com/thmb/8QzNWDvGhdry6V1jnyJWIhKA_nk=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/20144-banana-banana-bread-mfs-57-0bb49d050a6941c4b3715e57b8e6badd.jpg",
                    ingredients = listOf(
                        "Flour",
                        "Baking Soda",
                        "Salt",
                        "Butter",
                        "Brown Sugar",
                        "Eggs",
                        "Bananas"
                    ),
                ),
                Recipe(
                    id = "1",
                    name = "Banana Banana Bread",
                    imagePath = "https://www.allrecipes.com/thmb/8QzNWDvGhdry6V1jnyJWIhKA_nk=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/20144-banana-banana-bread-mfs-57-0bb49d050a6941c4b3715e57b8e6badd.jpg",
                    ingredients = listOf(
                        "Flour",
                        "Baking Soda",
                        "Salt",
                        "Butter",
                        "Brown Sugar",
                        "Eggs",
                        "Bananas"
                    ),
                ),
            )
        )
    }
}