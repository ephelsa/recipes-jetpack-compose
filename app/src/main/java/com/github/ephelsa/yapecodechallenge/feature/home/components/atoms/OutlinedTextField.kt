package com.github.ephelsa.yapecodechallenge.feature.home.components.atoms

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.ephelsa.yapecodechallenge.shared.utils.ResultCallback

@Composable
internal fun OutlinedTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: ResultCallback<String>,
) {
    var hasFocus by remember { mutableStateOf(false) }

    val color = if (hasFocus || value.isNotEmpty()) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.onSurface
    }

    BasicTextField(modifier = modifier.onFocusChanged { focusState ->
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
            BoxWithConstraints(contentAlignment = Alignment.Center, modifier = modifier
                .drawBehind {
                    val strokeWidth = (2.dp * density).value
                    val y = size.height - strokeWidth / 2

                    drawLine(
                        color, Offset(0f, y), Offset(size.width, y), strokeWidth
                    )
                }
                .padding(vertical = 6.dp, horizontal = 6.dp)) { textField() }
        })
}

@Preview
@Composable
internal fun PreviewOutlinedTextField() {
    var value by remember { mutableStateOf("") }

    OutlinedTextField(value = value, onValueChange = { value = it })
}