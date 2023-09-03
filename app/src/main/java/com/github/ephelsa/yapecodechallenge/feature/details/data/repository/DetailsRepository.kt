package com.github.ephelsa.yapecodechallenge.feature.details.data.repository

import com.github.ephelsa.yapecodechallenge.feature.details.data.model.RecipeExtraInfo

interface DetailsRepository {
    suspend fun getRecipeExtraInfo(id: String): Result<RecipeExtraInfo>
}