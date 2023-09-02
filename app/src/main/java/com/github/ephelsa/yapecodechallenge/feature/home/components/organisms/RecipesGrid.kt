package com.github.ephelsa.yapecodechallenge.feature.home.components.organisms

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.ephelsa.yapecodechallenge.feature.home.components.molecules.RecipeCard
import com.github.ephelsa.yapecodechallenge.feature.home.data.model.Recipe
import com.github.ephelsa.yapecodechallenge.shared.utils.ResultCallback

@Composable
internal fun RecipesGrid(
    recipes: List<Recipe>,
    areLoading: Boolean,
    loadingItemSize: Int,
    onRecipeClick: ResultCallback<Recipe>,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        content = {
            val cardModifier = Modifier
                .height(180.dp)
                .fillMaxWidth()

            if (areLoading) {
                items(loadingItemSize) {
                    RecipeCard(
                        modifier = cardModifier,
                        isLoading = true,
                        recipe = null,
                        onClick = null
                    )
                }
            }
            items(recipes) { recipe ->
                RecipeCard(
                    modifier = cardModifier,
                    isLoading = areLoading,
                    recipe = recipe,
                    onClick = { onRecipeClick(recipe) }
                )
            }
        },
    )
}