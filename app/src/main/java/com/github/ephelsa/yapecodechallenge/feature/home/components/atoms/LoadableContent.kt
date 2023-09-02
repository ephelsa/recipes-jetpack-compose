package com.github.ephelsa.yapecodechallenge.feature.home.components.atoms

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.ephelsa.yapecodechallenge.shared.theme.Colors
import com.github.ephelsa.yapecodechallenge.shared.utils.VoidCallback

@Composable
internal fun LoadableContent(
    modifier: Modifier = Modifier,
    isLoading: Boolean,
    content: @Composable VoidCallback,
) {
    BoxWithConstraints(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        if (isLoading) {
            ShimmerLoader(modifier)
        } else {
            content()
        }
    }
}

@Composable
internal fun ShimmerLoader(modifier: Modifier) {
    val infinityTransition = rememberInfiniteTransition()

    val animation = infinityTransition.animateFloat(
        initialValue = -0.4f,
        targetValue = 0.2f,
        animationSpec = infiniteRepeatable(tween(3_000), RepeatMode.Reverse)
    )

    Box(
        modifier = modifier
            .background(
                brush = Brush.verticalGradient(
                    Pair(0.2f + animation.value, Colors.WhiteSmoke),
                    Pair(0.6f + animation.value, Colors.Silver),
                    Pair(0.8f + animation.value, Colors.WhiteSmoke),
                ),
                shape = RoundedCornerShape(4.dp)
            ),
    )
}

@Preview
@Composable
internal fun PreviewLoadableText() {
    LoadableContent(isLoading = true) {
        Text(text = "Example")
    }
}