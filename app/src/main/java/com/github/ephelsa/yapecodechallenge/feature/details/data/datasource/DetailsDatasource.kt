package com.github.ephelsa.yapecodechallenge.feature.details.data.datasource

import com.github.ephelsa.yapecodechallenge.feature.details.data.model.RecipeExtraInfo

interface DetailsDatasource {
    suspend fun fetchDetails(id: String): RecipeExtraInfo
}