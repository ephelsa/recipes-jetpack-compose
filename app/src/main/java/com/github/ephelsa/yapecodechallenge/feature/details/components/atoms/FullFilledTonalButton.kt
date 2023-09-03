package com.github.ephelsa.yapecodechallenge.feature.details.components.atoms

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledTonalButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.ephelsa.yapecodechallenge.shared.utils.VoidCallback

@Composable
fun FullFilledTonalButton(
    modifier: Modifier = Modifier,
    isLoading: Boolean,
    onClick: VoidCallback,
    content: @Composable VoidCallback,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        contentAlignment = Alignment.Center,
    ) {
        FilledTonalButton(
            modifier = Modifier.fillMaxWidth(0.7f),
            enabled = !isLoading,
            onClick = onClick,
        ) {
            Crossfade(targetState = isLoading) {
                if (it) {
                    CircularProgressIndicator(modifier = Modifier.size(18.dp), strokeWidth = 2.dp)
                } else {
                    content()
                }
            }
        }
    }
}