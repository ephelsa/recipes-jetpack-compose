package com.github.ephelsa.yapecodechallenge.feature.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.github.ephelsa.yapecodechallenge.feature.home.components.templates.HomeTemplate
import com.github.ephelsa.yapecodechallenge.feature.home.data.model.Recipe

@Composable
internal fun HomeScreen() {
    var currentFilterSelected by remember { mutableStateOf(0) }
    var searchText by remember { mutableStateOf("") }

    HomeTemplate(
        filterOptions = listOf("Name", "Ingredients"),
        selectedFilterIndex = currentFilterSelected,
        onClickFilter = { currentFilterSelected = it },
        searchValue = searchText,
        onSearchChange = { searchText = it },
        recipes = listOf(
            Recipe(
                id = "1",
                name = "Banana Banana Bread",
                imagePath = "https://www.allrecipes.com/thmb/8QzNWDvGhdry6V1jnyJWIhKA_nk=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/20144-banana-banana-bread-mfs-57-0bb49d050a6941c4b3715e57b8e6badd.jpg",
                ingredients = listOf(
                    "Flour",
                    "Baking Soda",
                    "Salt",
                    "Butter",
                    "Brown Sugar",
                    "Eggs",
                    "Bananas"
                ),
            ),
            Recipe(
                id = "1",
                name = "Banana Banana Bread",
                imagePath = "https://www.allrecipes.com/thmb/8QzNWDvGhdry6V1jnyJWIhKA_nk=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/20144-banana-banana-bread-mfs-57-0bb49d050a6941c4b3715e57b8e6badd.jpg",
                ingredients = listOf(
                    "Flour",
                    "Baking Soda",
                    "Salt",
                    "Butter",
                    "Brown Sugar",
                    "Eggs",
                    "Bananas"
                ),
            ),
            Recipe(
                id = "1",
                name = "Banana Banana Bread",
                imagePath = "https://www.allrecipes.com/thmb/8QzNWDvGhdry6V1jnyJWIhKA_nk=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/20144-banana-banana-bread-mfs-57-0bb49d050a6941c4b3715e57b8e6badd.jpg",
                ingredients = listOf(
                    "Flour",
                    "Baking Soda",
                    "Salt",
                    "Butter",
                    "Brown Sugar",
                    "Eggs",
                    "Bananas"
                ),
            ),
            Recipe(
                id = "1",
                name = "Banana Banana Bread",
                imagePath = "https://www.allrecipes.com/thmb/8QzNWDvGhdry6V1jnyJWIhKA_nk=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/20144-banana-banana-bread-mfs-57-0bb49d050a6941c4b3715e57b8e6badd.jpg",
                ingredients = listOf(
                    "Flour",
                    "Baking Soda",
                    "Salt",
                    "Butter",
                    "Brown Sugar",
                    "Eggs",
                    "Bananas"
                ),
            ),
            Recipe(
                id = "1",
                name = "Banana Banana Bread",
                imagePath = "https://www.allrecipes.com/thmb/8QzNWDvGhdry6V1jnyJWIhKA_nk=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/20144-banana-banana-bread-mfs-57-0bb49d050a6941c4b3715e57b8e6badd.jpg",
                ingredients = listOf(
                    "Flour",
                    "Baking Soda",
                    "Salt",
                    "Butter",
                    "Brown Sugar",
                    "Eggs",
                    "Bananas"
                ),
            ),
        ),
        onRecipeClick = { recipe -> }
    )
}

