package com.github.ephelsa.yapecodechallenge.feature.home.data.datasource

import com.github.ephelsa.yapecodechallenge.feature.home.data.model.Recipe

interface RecipesDatasource {
    suspend fun fetchRecipes(): List<Recipe>
}
