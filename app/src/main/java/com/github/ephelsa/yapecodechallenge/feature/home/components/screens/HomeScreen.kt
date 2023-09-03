package com.github.ephelsa.yapecodechallenge.feature.home.components.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.github.ephelsa.yapecodechallenge.feature.home.HomeViewModel
import com.github.ephelsa.yapecodechallenge.feature.home.components.templates.HomeErrorTemplate
import com.github.ephelsa.yapecodechallenge.feature.home.components.templates.HomeTemplate
import com.github.ephelsa.yapecodechallenge.feature.home.data.model.Recipe
import com.github.ephelsa.yapecodechallenge.shared.utils.ResultCallback

@Composable
internal fun HomeScreen(
    viewModel: HomeViewModel,
    onRecipeClick: ResultCallback<Recipe>,
) {
    val onSearchText by viewModel.onSearchText.collectAsState()
    val onRecipesLoading by viewModel.onRecipesLoading.collectAsState()
    val onRecipesResult by viewModel.onRecipesResult.collectAsState()
    val onRecipesSearchResult by viewModel.onRecipesSearchResult.collectAsState()
    val onFilterSelected by viewModel.onFilterSelected.collectAsState()

    onRecipesResult?.onFailure {
        HomeErrorTemplate(
            exception = it,
            onRetryClick = {
                viewModel.fetchRecipesList()
            },
        )
    }

    if (onRecipesLoading || onRecipesResult?.isSuccess == true) {
        HomeTemplate(
            filterOptions = viewModel.filterOptions,
            selectedFilter = onFilterSelected,
            onClickFilter = { viewModel.changeCurrentFilter(it) },
            searchPlaceholderList = viewModel.placeholderOptions,
            searchValue = onSearchText,
            onSearchChange = { viewModel.changeSearchQuery(it) },
            recipes = onRecipesSearchResult ?: onRecipesResult?.getOrNull() ?: listOf(),
            areRecipesLoading = onRecipesLoading,
            onRecipeClick = onRecipeClick
        )
    }
}
