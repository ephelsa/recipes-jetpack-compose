package com.github.ephelsa.yapecodechallenge.feature.home.components.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.github.ephelsa.yapecodechallenge.feature.home.components.atoms.LoadableContent
import com.github.ephelsa.yapecodechallenge.feature.home.data.model.Recipe
import com.github.ephelsa.yapecodechallenge.shared.theme.Colors
import com.github.ephelsa.yapecodechallenge.shared.utils.VoidCallback

@Composable
internal fun RecipeCard(
    modifier: Modifier = Modifier,
    isLoading: Boolean,
    recipe: Recipe?,
    onClick: VoidCallback?,
) {
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 8.dp)
            .clickable(onClick = { if (!isLoading) onClick?.invoke() }),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        LoadableContent(
            modifier = modifier,
            isLoading = isLoading
        ) {
            Box(
                contentAlignment = Alignment.BottomCenter
            ) {
                AsyncImage(
                    modifier = modifier,
                    model = recipe?.imagePath,
                    contentDescription = recipe?.name,
                    contentScale = ContentScale.Crop,
                )
                Column(
                    modifier = Modifier
                        .background(Colors.Grey.copy(alpha = 0.6f))
                        .padding(bottom = 8.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom,
                ) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = recipe!!.name,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.background,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
internal fun PreviewRecipeCard() {
    RecipeCard(
        isLoading = false,
        recipe = Recipe(
            id = "1",
            name = "Banana Banana Bread",
            imagePath = "https://www.allrecipes.com/thmb/8QzNWDvGhdry6V1jnyJWIhKA_nk=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/20144-banana-banana-bread-mfs-57-0bb49d050a6941c4b3715e57b8e6badd.jpg",
            ingredients = listOf(
                "Flour",
                "Baking Soda",
                "Salt",
                "Butter",
                "Brown Sugar",
                "Eggs",
                "Bananas"
            ),
        ),
        onClick = {}
    )
}