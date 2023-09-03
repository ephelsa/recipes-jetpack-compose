package com.github.ephelsa.yapecodechallenge.feature.details.utils

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

fun LazyListScope.itemBoxed(
    key: Any? = null,
    contentType: Any? = null,
    modifier: Modifier = Modifier,
    content: @Composable LazyItemScope.() -> Unit
) {
    item(key = key, contentType = contentType) {
        Box(modifier = modifier) {
            content()
        }
    }
}