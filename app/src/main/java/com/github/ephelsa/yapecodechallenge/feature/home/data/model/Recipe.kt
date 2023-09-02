package com.github.ephelsa.yapecodechallenge.feature.home.data.model

data class Recipe(
    val id: String,
    val name: String,
    val imagePath: String,
    val ingredients: List<String>,
)
