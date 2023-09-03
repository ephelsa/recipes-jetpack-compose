package com.github.ephelsa.yapecodechallenge.feature.details.api

import com.github.ephelsa.yapecodechallenge.feature.details.data.datasource.DetailsDatasource
import com.github.ephelsa.yapecodechallenge.feature.details.data.model.RecipeExtraInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DetailsDatasourceImpl(
    private val detailsService: DetailsService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : DetailsDatasource {
    override suspend fun fetchDetails(id: String): RecipeExtraInfo = withContext(dispatcher) {
        // Well, due the API is a free plan of Mockable, the id have to be mocked too
        val response = detailsService.fetchDetails("")

        response.asDomainModel()
    }
}