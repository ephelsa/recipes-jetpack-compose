package com.github.ephelsa.yapecodechallenge.feature.details.api

import retrofit2.http.GET
import retrofit2.http.Query

interface DetailsService {
    @GET("recipes")
    suspend fun fetchDetails(@Query("details") id: String): DetailsDAO
}