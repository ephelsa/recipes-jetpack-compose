package com.github.ephelsa.yapecodechallenge.feature.home.utils

import com.github.ephelsa.yapecodechallenge.feature.home.data.model.Recipe

interface FindRecipeStrategy {
    fun find(): List<Recipe>

    companion object {
        fun find(strategy: FindRecipeStrategy): List<Recipe> = strategy.find()
    }
}