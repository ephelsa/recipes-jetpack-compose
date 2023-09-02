package com.github.ephelsa.yapecodechallenge.feature.home.data.repository

import com.github.ephelsa.yapecodechallenge.feature.home.data.datasource.RecipesDatasource
import com.github.ephelsa.yapecodechallenge.feature.home.data.model.Recipe
import kotlinx.coroutines.delay

internal class RecipeRepositoryImpl(
    private val recipesDatasource: RecipesDatasource,
) : RecipeRepository {
    override suspend fun fetchRecipesList(): Result<List<Recipe>> = try {
        delay(2_000)
        Result.success(recipesDatasource.fetchRecipes())
    } catch (e: Exception) {
        Result.failure(e)
    }
}
