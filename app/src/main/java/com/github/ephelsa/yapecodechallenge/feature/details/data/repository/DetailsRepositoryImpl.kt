package com.github.ephelsa.yapecodechallenge.feature.details.data.repository

import com.github.ephelsa.yapecodechallenge.feature.details.data.datasource.DetailsDatasource
import com.github.ephelsa.yapecodechallenge.feature.details.data.model.RecipeExtraInfo
import kotlinx.coroutines.delay

class DetailsRepositoryImpl(
    private val detailsDatasource: DetailsDatasource,
) : DetailsRepository {
    override suspend fun getRecipeExtraInfo(id: String): Result<RecipeExtraInfo> = try {
        delay(2_000)

        val result = detailsDatasource.fetchDetails(id)
        Result.success(result)
    } catch (e: Exception) {
        Result.failure(e)
    }
}