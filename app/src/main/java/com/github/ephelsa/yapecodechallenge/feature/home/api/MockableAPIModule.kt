package com.github.ephelsa.yapecodechallenge.feature.home.api

import com.github.ephelsa.yapecodechallenge.shared.api.MockableAPI

internal object MockableAPIModule {
    val recipesService: RecipesService = MockableAPI.client().create(RecipesService::class.java)
}