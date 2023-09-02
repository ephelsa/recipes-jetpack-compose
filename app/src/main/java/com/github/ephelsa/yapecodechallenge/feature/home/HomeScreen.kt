package com.github.ephelsa.yapecodechallenge.feature.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.github.ephelsa.yapecodechallenge.feature.home.components.templates.HomeTemplate

@Composable
internal fun HomeScreen(
    viewModel: HomeViewModel
) {
    val onSearchText by viewModel.onSearchText.collectAsState()
    val onRecipesLoading by viewModel.onRecipesLoading.collectAsState()
    val onRecipesResult by viewModel.onRecipesResult.collectAsState()
    val onRecipesSearchResult by viewModel.onRecipesSearchResult.collectAsState()
    val onFilterSelected by viewModel.onFilterSelected.collectAsState()

    HomeTemplate(
        filterOptions = viewModel.filterOptions,
        selectedFilter = onFilterSelected,
        onClickFilter = { viewModel.changeCurrentFilter(it) },
        searchPlaceholderList = viewModel.placeholderOptions,
        searchValue = onSearchText,
        onSearchChange = { viewModel.changeSearchQuery(it) },
        recipes = onRecipesSearchResult ?: onRecipesResult?.getOrNull() ?: listOf(),
        areRecipesLoading = onRecipesLoading,
        onRecipeClick = { recipe ->
            // TODO: Add navigation
        }
    )
}
