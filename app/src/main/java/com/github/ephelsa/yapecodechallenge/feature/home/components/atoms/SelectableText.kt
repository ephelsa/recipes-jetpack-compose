package com.github.ephelsa.yapecodechallenge.feature.home.components.atoms

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.ephelsa.yapecodechallenge.shared.utils.VoidCallback

@Composable
fun SelectableText(
    modifier: Modifier = Modifier,
    text: String,
    isSelected: Boolean,
    onClick: VoidCallback,
) {
    var mModifier: Modifier = modifier
    val selectedColor: Color
    val fontWeight: FontWeight

    if (isSelected) {
        selectedColor = MaterialTheme.colorScheme.primary
        fontWeight = FontWeight.Bold

        mModifier = modifier.border(
            width = 2.dp,
            color = selectedColor,
            shape = MaterialTheme.shapes.small
        )
    } else {
        selectedColor = MaterialTheme.colorScheme.tertiary
        fontWeight = FontWeight.Normal
    }

    Box(
        modifier = mModifier
            .clickable(onClick = onClick)
            .padding(horizontal = 8.dp, vertical = 4.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            color = selectedColor,
            fontWeight = fontWeight
        )
    }
}

@Preview
@Composable
fun PreviewSelectableText() {
    SelectableText(text = "Name", isSelected = false) {

    }
}