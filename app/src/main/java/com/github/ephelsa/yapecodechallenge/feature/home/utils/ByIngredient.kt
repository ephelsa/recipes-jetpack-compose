package com.github.ephelsa.yapecodechallenge.feature.home.utils

import com.github.ephelsa.yapecodechallenge.feature.home.data.model.Recipe

class ByIngredient(
    private val query: String,
    private val recipes: List<Recipe>,
) : FindRecipeStrategy {

    override fun find(): List<Recipe> {
        val filteredRecipes = mutableListOf<Recipe>()

        for (recipe in recipes) {
            for (simplifiedQuery in separateQuery()) {
                val containsIngredient = recipe.ingredients.find {
                        it.contains(simplifiedQuery, ignoreCase = true)
                    }

                if (!containsIngredient.isNullOrEmpty()) {
                    filteredRecipes.add(recipe)
                    break
                }
            }
        }

        return filteredRecipes
    }

    private fun separateQuery(): List<String> {
        return query.split(";").map { it.trim() }
    }
}