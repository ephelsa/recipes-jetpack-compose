package com.github.ephelsa.yapecodechallenge.feature.home.data.repository

import com.github.ephelsa.yapecodechallenge.feature.home.api.MockableAPIModule
import com.github.ephelsa.yapecodechallenge.feature.home.api.RecipesDatasourceImpl

internal object RepositoryModule {
    val recipeRepository: RecipeRepository = RecipeRepositoryImpl(
        RecipesDatasourceImpl(MockableAPIModule.recipesService)
    )
}