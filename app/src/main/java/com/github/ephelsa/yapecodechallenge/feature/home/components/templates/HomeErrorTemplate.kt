package com.github.ephelsa.yapecodechallenge.feature.home.components.templates

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import com.github.ephelsa.yapecodechallenge.BuildConfig
import com.github.ephelsa.yapecodechallenge.shared.utils.VoidCallback

@Composable
// TODO: Use the exception to display different errors
internal fun HomeErrorTemplate(exception: Throwable, onRetryClick: VoidCallback) {
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Something went wrong loading the content.")

            if (BuildConfig.DEBUG) {
                Text(text = exception.message.toString(), style = MaterialTheme.typography.labelSmall)
            }
            Button(onClick = onRetryClick) {
                Text(text = "Retry")
            }
        }
    }
}