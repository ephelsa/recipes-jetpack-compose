package com.github.ephelsa.yapecodechallenge.feature.home.data.repository

import com.github.ephelsa.yapecodechallenge.feature.home.data.model.Recipe

interface RecipeRepository {
    suspend fun fetchRecipesList(): Result<List<Recipe>>
}