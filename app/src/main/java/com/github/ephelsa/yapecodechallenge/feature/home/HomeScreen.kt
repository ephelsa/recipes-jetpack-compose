package com.github.ephelsa.yapecodechallenge.feature.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.github.ephelsa.yapecodechallenge.feature.home.components.templates.HomeTemplate

@Composable
internal fun HomeScreen() {
    var currentFilterSelected by remember { mutableStateOf(0) }
    var searchText by remember { mutableStateOf("") }

    HomeTemplate(
        filterOptions = listOf("Name", "Ingredients"),
        selectedFilterIndex = currentFilterSelected,
        onClickFilter = { currentFilterSelected = it },
        searchValue = searchText,
        onSearchChange = { searchText = it }
    )
}

