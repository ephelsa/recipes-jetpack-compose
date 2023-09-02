package com.github.ephelsa.yapecodechallenge.shared.api

import com.github.ephelsa.yapecodechallenge.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MockableAPI {
    fun client(): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}