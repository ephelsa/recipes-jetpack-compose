package com.github.ephelsa.yapecodechallenge.feature.details

import app.cash.turbine.test
import com.github.ephelsa.yapecodechallenge.feature.details.data.repository.DetailsRepository
import com.github.ephelsa.yapecodechallenge.feature.home.data.model.Recipe
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe
import io.mockk.Called
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.setMain

@OptIn(ExperimentalCoroutinesApi::class)
internal class DetailsViewModelTest : FunSpec({
    lateinit var detailsRepositoryMock: DetailsRepository

    beforeEach {
        Dispatchers.setMain(StandardTestDispatcher())
        detailsRepositoryMock = mockk()
    }

    context("fetchDetails") {
        test("when onCurrentRecipe is null then should cancel the job").config(coroutineTestScope = true) {
            val viewModel = DetailsViewModel(detailsRepositoryMock)

            viewModel.fetchDetails()

            viewModel.onRecipeExtraInfo.test {
                awaitItem().shouldBeNull()
            }
        }

        test("when onCurrentRecipe is not null then onRecipeExtraInfo should be set").config(
            coroutineTestScope = true
        ) {
            val viewModel = spyk(DetailsViewModel(detailsRepositoryMock))
            viewModel.onCurrentRecipe.value = Recipe(
                id = "testId",
                name = "Test",
                imagePath = "",
                ingredients = listOf()
            )
            coEvery { detailsRepositoryMock.getRecipeExtraInfo(any()) } returns Result.failure(
                Exception()
            )

            viewModel.fetchDetails()

            viewModel.onRecipeExtraInfo.test {
                awaitItem().shouldBeNull()
                awaitItem()?.isFailure?.shouldBeTrue()
            }
        }
    }

    context("setRecipe") {
        test("when recipe is null then on onNullRecipeReceivedError should be set") {
            val viewModel = spyk(DetailsViewModel(detailsRepositoryMock))

            viewModel.setRecipe(null)

            viewModel.onNullRecipeReceivedError.test {
                awaitItem().shouldBe(Unit)
            }

            verify { viewModel.fetchDetails() wasNot Called }
        }

        test("when recipe is not null then onCurrentRecipe should be set and fetchDetails called") {
            val viewModel = spyk(DetailsViewModel(detailsRepositoryMock))
            val recipe = Recipe(
                id = "testId",
                name = "Test",
                imagePath = "",
                ingredients = listOf()
            )

            viewModel.setRecipe(recipe)

            viewModel.onCurrentRecipe.test {
                awaitItem().shouldBe(recipe)
            }

            verify { viewModel.fetchDetails() }
        }
    }
})