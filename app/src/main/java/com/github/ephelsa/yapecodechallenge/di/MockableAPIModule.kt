package com.github.ephelsa.yapecodechallenge.di

import com.github.ephelsa.yapecodechallenge.BuildConfig
import com.github.ephelsa.yapecodechallenge.feature.details.api.DetailsService
import com.github.ephelsa.yapecodechallenge.feature.home.api.RecipesService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MockableAPIModule {
    private fun client(): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun recipesService(): RecipesService = client().create(RecipesService::class.java)

    fun detailsService(): DetailsService = client().create(DetailsService::class.java)
}