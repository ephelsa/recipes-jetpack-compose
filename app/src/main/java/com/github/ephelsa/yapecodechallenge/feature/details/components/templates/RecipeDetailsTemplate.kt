package com.github.ephelsa.yapecodechallenge.feature.details.components.templates

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.github.ephelsa.yapecodechallenge.R
import com.github.ephelsa.yapecodechallenge.feature.details.components.atoms.FullFilledTonalButton
import com.github.ephelsa.yapecodechallenge.feature.details.data.model.RecipeExtraInfo
import com.github.ephelsa.yapecodechallenge.feature.details.utils.itemBoxed
import com.github.ephelsa.yapecodechallenge.feature.home.data.model.Recipe
import com.github.ephelsa.yapecodechallenge.shared.components.atoms.LoadableContent
import com.github.ephelsa.yapecodechallenge.shared.components.organisms.NavigationBar
import com.github.ephelsa.yapecodechallenge.shared.utils.VoidCallback

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailsTemplate(
    recipe: Recipe,
    recipeExtraInfo: RecipeExtraInfo?,
    onNavigateBackClick: VoidCallback,
    onMapClick: VoidCallback,
) {
    val isLoading = recipeExtraInfo == null

    Scaffold(
        topBar = {
            NavigationBar(
                onBackButtonClick = onNavigateBackClick,
                title = stringResource(id = R.string.label_recipe)
            )
        },
        bottomBar = {
            FullFilledTonalButton(onClick = onMapClick, isLoading = isLoading) {
                Text(text = stringResource(id = R.string.btn_find_location))
            }
        }
    ) { paddings ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddings),
        ) {
            item {
                AsyncImage(
                    model = recipe.imagePath,
                    contentDescription = "${recipe.name}_image",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }

            itemBoxed(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .padding(top = 8.dp, bottom = 16.dp)
            ) {
                Column {
                    Text(
                        text = recipe.name,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )

                    var modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth()

                    if (isLoading) {
                        modifier = modifier.height(180.dp)
                    }

                    LoadableContent(
                        modifier = modifier,
                        targetData = recipeExtraInfo
                    ) {
                        Text(text = it.description)
                    }
                }
            }
        }
    }
}