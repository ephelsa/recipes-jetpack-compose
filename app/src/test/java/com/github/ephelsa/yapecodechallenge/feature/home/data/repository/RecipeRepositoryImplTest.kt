package com.github.ephelsa.yapecodechallenge.feature.home.data.repository

import com.github.ephelsa.yapecodechallenge.feature.home.data.datasource.RecipesDatasource
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.result.shouldBeFailure
import io.kotest.matchers.result.shouldBeSuccess
import io.mockk.coEvery
import io.mockk.mockk

internal class RecipeRepositoryImplTest : ShouldSpec({
    lateinit var recipesDatasourceMock: RecipesDatasource
    lateinit var repository: RecipeRepositoryImpl

    beforeEach {
        recipesDatasourceMock = mockk()
        repository = RecipeRepositoryImpl(recipesDatasourceMock)
    }

    context("fetchRecipesList") {
        should("return success when datasource doesn't fail") {
            coEvery { recipesDatasourceMock.fetchRecipes() } returns listOf()
            repository.fetchRecipesList() shouldBeSuccess listOf()
        }

        should("return failure when datasource throws an exception") {
            val exception = Exception("something went wrong")
            coEvery { recipesDatasourceMock.fetchRecipes() } throws exception
            repository.fetchRecipesList() shouldBeFailure exception
        }
    }
})
