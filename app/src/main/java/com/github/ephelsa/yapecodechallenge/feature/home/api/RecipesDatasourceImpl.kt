package com.github.ephelsa.yapecodechallenge.feature.home.api

import com.github.ephelsa.yapecodechallenge.feature.home.data.datasource.RecipesDatasource
import com.github.ephelsa.yapecodechallenge.feature.home.data.model.Recipe
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecipesDatasourceImpl(
    private val recipesService: RecipesService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : RecipesDatasource {
    override suspend fun fetchRecipes(): List<Recipe> = withContext(dispatcher) {
        val response = recipesService.fetchRecipes()

        response.asDomainModel()
    }
}
