package com.github.ephelsa.yapecodechallenge.feature.home.components.organisms

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.github.ephelsa.yapecodechallenge.R
import com.github.ephelsa.yapecodechallenge.feature.home.components.atoms.OutlinedTextField
import com.github.ephelsa.yapecodechallenge.feature.home.components.molecules.SelectableItem
import com.github.ephelsa.yapecodechallenge.shared.utils.ResultCallback

@Composable
internal fun <T : Any> SearchBar(
    modifier: Modifier = Modifier,
    displayableContent: List<T>,
    selectedFilterIndex: Int,
    onClickFilter: ResultCallback<Int>,
    textValue: String,
    onTextChange: ResultCallback<String>,
) {
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Row(
            modifier = Modifier.padding(bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(0.8f),
                value = textValue,
                onValueChange = onTextChange,
            )

            Crossfade(targetState = isExpanded) {
                val iconId: Int
                val contentDescription: Int

                if (!it) {
                    iconId = R.drawable.baseline_tune_24
                    contentDescription = R.string.cd_expand_filters
                } else {
                    iconId = R.drawable.baseline_keyboard_double_arrow_up_24
                    contentDescription = R.string.cd_collapse_filters
                }

                Icon(
                    painter = painterResource(iconId),
                    contentDescription = stringResource(contentDescription),
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .clickable { isExpanded = !isExpanded },
                    tint = MaterialTheme.colorScheme.primary,
                )
            }
        }

        AnimatedVisibility(visible = isExpanded) {
            SelectableItem(
                displayableContent = displayableContent,
                selectedIndex = selectedFilterIndex,
                onClickItem = onClickFilter,
            )
        }
    }
}