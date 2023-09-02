package com.github.ephelsa.yapecodechallenge.feature.home.components.atoms

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.ephelsa.yapecodechallenge.shared.utils.ResultCallback
import com.github.ephelsa.yapecodechallenge.shared.utils.VoidCallback

@Composable
internal fun OutlinedTextField(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String,
    hideKeyboard: Boolean,
    onClearFocus: VoidCallback,
    onValueChange: ResultCallback<String>,
) {
    val focusManager = LocalFocusManager.current
    var hasFocus by remember { mutableStateOf(false) }

    val focused = hasFocus || value.isNotEmpty()
    val color = if (focused) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.onSurface
    }

    BasicTextField(
        modifier = modifier.onFocusChanged { focusState ->
            hasFocus = focusState.hasFocus
        },
        value = value,
        textStyle = TextStyle(
            textAlign = TextAlign.Center,
            color = color,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp
        ),
        onValueChange = onValueChange,
        singleLine = true,
        decorationBox = { textField ->
            BoxWithConstraints(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .drawBehind {
                        val strokeWidth = (2.dp * density).value
                        val y = size.height - strokeWidth / 2

                        drawLine(
                            color, Offset(0f, y), Offset(size.width, y), strokeWidth
                        )
                    }
                    .padding(vertical = 6.dp, horizontal = 6.dp)
            ) {
                Crossfade(targetState = !focused, animationSpec = tween(600)) {
                    if (it) {
                        Text(
                            text = placeholder,
                            style = TextStyle(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f))
                        )
                    }
                }
                textField()
            }
        }
    )

    if (hideKeyboard) {
        focusManager.clearFocus()
        onClearFocus()
    }
}

@Preview
@Composable
internal fun PreviewOutlinedTextField() {
    var value by remember { mutableStateOf("") }

    OutlinedTextField(
        value = value,
        onValueChange = { value = it },
        placeholder = "Banana",
        hideKeyboard = true,
        onClearFocus = {}
    )
}