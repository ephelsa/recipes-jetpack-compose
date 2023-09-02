package com.github.ephelsa.yapecodechallenge.feature.home.components.templates

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.github.ephelsa.yapecodechallenge.feature.home.components.organisms.RecipesGrid
import com.github.ephelsa.yapecodechallenge.feature.home.components.organisms.SearchBar
import com.github.ephelsa.yapecodechallenge.feature.home.data.model.Recipe
import com.github.ephelsa.yapecodechallenge.shared.utils.ResultCallback

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun <Filter : Any> HomeTemplate(
    filterOptions: List<Filter>,
    selectedFilter: Filter,
    onClickFilter: ResultCallback<Filter>,
    searchPlaceholderList: List<String>,
    searchValue: String,
    onSearchChange: ResultCallback<String>,
    recipes: List<Recipe>,
    areRecipesLoading: Boolean,
    onRecipeClick: ResultCallback<Recipe>
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        Surface {
            Scaffold(
                topBar = {
                    AnimatedVisibility(visible = !areRecipesLoading, enter = expandVertically()) {
                        SearchBar(
                            filtersContent = filterOptions,
                            selectedFilter = selectedFilter,
                            onClickFilter = onClickFilter,
                            textValue = searchValue,
                            onTextChange = onSearchChange,
                            placeholderList = searchPlaceholderList
                        )
                    }
                },
                content = { it ->
                    Column(
                        modifier = Modifier.padding(
                            top = it.calculateTopPadding(),
                            bottom = it.calculateBottomPadding(),
                            start = it.calculateStartPadding(LayoutDirection.Ltr) + 8.dp,
                            end = it.calculateEndPadding(LayoutDirection.Ltr) + 8.dp,
                        )
                    ) {
                        RecipesGrid(
                            recipes = recipes,
                            areLoading = areRecipesLoading,
                            onRecipeClick = onRecipeClick,
                            loadingItemSize = 10
                        )
                    }
                }
            )
        }
    }
}