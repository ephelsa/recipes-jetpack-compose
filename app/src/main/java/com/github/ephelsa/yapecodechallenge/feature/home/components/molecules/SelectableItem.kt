package com.github.ephelsa.yapecodechallenge.feature.home.components.molecules

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.ephelsa.yapecodechallenge.feature.home.components.atoms.SelectableText
import com.github.ephelsa.yapecodechallenge.shared.utils.ResultCallback

@Composable
internal fun <T : Any> SelectableItem(
    displayableContent: List<T>,
    selectedContent: T?,
    onClickItem: ResultCallback<T>,
) {
    val totalItems = displayableContent.size

    LazyRow {
        items(totalItems) { index ->
            val item: T = displayableContent[index]

            val marginLeft = if (index == 0) 0.dp else 2.dp
            val marginRight = if (index == totalItems) 0.dp else 2.dp

            SelectableText(
                modifier = Modifier.padding(start = marginLeft, end = marginRight),
                text = item.toString(),
                isSelected = selectedContent == item,
                onClick = { onClickItem(item) }
            )
        }
    }

}

@Preview
@Composable
internal fun PreviewSelectableItem() {
    val list = listOf("Name", "Ingredients")

    SelectableItem(
        displayableContent = list,
        selectedContent = null,
        onClickItem = {
            print("Item -> $it")
        }
    )
}