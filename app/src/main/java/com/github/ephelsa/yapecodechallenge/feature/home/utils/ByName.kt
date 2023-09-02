package com.github.ephelsa.yapecodechallenge.feature.home.utils

import com.github.ephelsa.yapecodechallenge.feature.home.data.model.Recipe

internal class ByName(
    private val query: String,
    private val recipes: List<Recipe>,
) : FindRecipeStrategy {

    override fun find(): List<Recipe> {
        return recipes.filter { it.name.contains(query, ignoreCase = true) }
    }
}