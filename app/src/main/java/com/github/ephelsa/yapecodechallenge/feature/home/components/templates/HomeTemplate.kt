package com.github.ephelsa.yapecodechallenge.feature.home.components.templates

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.github.ephelsa.yapecodechallenge.feature.home.components.organisms.SearchBar
import com.github.ephelsa.yapecodechallenge.shared.utils.ResultCallback

@Composable
internal fun <Filter : Any> HomeTemplate(
    filterOptions: List<Filter>,
    selectedFilterIndex: Int,
    onClickFilter: ResultCallback<Int>,
    searchValue: String,
    onSearchChange: ResultCallback<String>,
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        Surface {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                SearchBar(
                    displayableContent = filterOptions,
                    selectedFilterIndex = selectedFilterIndex,
                    onClickFilter = onClickFilter,
                    textValue = searchValue,
                    onTextChange = onSearchChange,
                )
            }
        }
    }
}