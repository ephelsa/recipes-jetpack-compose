package com.github.ephelsa.yapecodechallenge.feature.home.components.organisms

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.KeyframesSpec
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.rememberInfiniteTransition
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
import com.github.ephelsa.yapecodechallenge.shared.utils.VoidCallback

@Composable
internal fun <T : Any> SearchBar(
    modifier: Modifier = Modifier,
    filtersContent: List<T>,
    selectedFilter: T,
    onClickFilter: ResultCallback<T>,
    placeholderList: List<String>,
    textValue: String,
    onTextChange: ResultCallback<String>,
    hideKeyboard: Boolean,
    onClearFocus: VoidCallback,
) {
    var isExpanded by remember { mutableStateOf(false) }

    val infiniteTransition = rememberInfiniteTransition()
    val placeholderAnimation = infiniteTransition.animateValue(
        initialValue = 0,
        targetValue = placeholderList.size,
        typeConverter = Int.VectorConverter,
        animationSpec = InfiniteRepeatableSpec(
            animation = KeyframesSpec(
                config = KeyframesSpec.KeyframesSpecConfig<Int>()
                    .apply { durationMillis = 6_000 }),
            repeatMode = RepeatMode.Restart,
        )
    )

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
                placeholder = placeholderList[placeholderAnimation.value],
                hideKeyboard = hideKeyboard,
                onClearFocus = onClearFocus,
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
                displayableContent = filtersContent,
                selectedContent = selectedFilter,
                onClickItem = onClickFilter,
            )
        }
    }
}