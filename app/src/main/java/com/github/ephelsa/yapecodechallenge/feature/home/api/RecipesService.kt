package com.github.ephelsa.yapecodechallenge.feature.home.api

import retrofit2.http.GET

interface RecipesService {
    @GET("recipes")
    suspend fun fetchRecipes(): RecipesDAO
}