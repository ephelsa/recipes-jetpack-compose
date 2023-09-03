package com.github.ephelsa.yapecodechallenge.shared.utils

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import com.github.ephelsa.yapecodechallenge.shared.theme.YapeCodeChallengeTheme

internal fun ComponentActivity.setYapeContent(
    parent: CompositionContext? = null,
    content: @Composable VoidCallback
) {
    setContent(parent) {
        YapeCodeChallengeTheme {
            content()
        }
    }
}

fun <T> Context.startComponentActivity(klass: Class<T>, onBundle: Bundle.() -> Unit) {
    val bundle = Bundle().apply { onBundle() }
    val intent = Intent(this, klass).apply {
        putExtras(bundle)
    }

    startActivity(intent)
}

