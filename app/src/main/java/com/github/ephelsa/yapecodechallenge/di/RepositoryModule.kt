package com.github.ephelsa.yapecodechallenge.di

import com.github.ephelsa.yapecodechallenge.feature.details.api.DetailsDatasourceImpl
import com.github.ephelsa.yapecodechallenge.feature.details.data.repository.DetailsRepository
import com.github.ephelsa.yapecodechallenge.feature.details.data.repository.DetailsRepositoryImpl
import com.github.ephelsa.yapecodechallenge.feature.home.api.RecipesDatasourceImpl
import com.github.ephelsa.yapecodechallenge.feature.home.data.repository.RecipeRepository
import com.github.ephelsa.yapecodechallenge.feature.home.data.repository.RecipeRepositoryImpl

object RepositoryModule {
    fun recipeRepository(): RecipeRepository = RecipeRepositoryImpl(
        RecipesDatasourceImpl(MockableAPIModule.recipesService())
    )

    fun detailsRepository(): DetailsRepository = DetailsRepositoryImpl(
        DetailsDatasourceImpl(MockableAPIModule.detailsService())
    )
}