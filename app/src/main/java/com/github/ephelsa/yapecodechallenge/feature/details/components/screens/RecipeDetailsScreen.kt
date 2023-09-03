package com.github.ephelsa.yapecodechallenge.feature.details.components.screens

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.DialogProperties
import com.github.ephelsa.yapecodechallenge.BuildConfig
import com.github.ephelsa.yapecodechallenge.R
import com.github.ephelsa.yapecodechallenge.feature.details.DetailsViewModel
import com.github.ephelsa.yapecodechallenge.feature.details.components.templates.RecipeDetailsTemplate
import com.github.ephelsa.yapecodechallenge.shared.utils.ResultCallback
import com.github.ephelsa.yapecodechallenge.shared.utils.VoidCallback

@Composable
fun RecipeDetailsScreen(
    viewModel: DetailsViewModel,
    onNavigateBackClick: VoidCallback,
    onMapClick: ResultCallback<String?>,
) {
    val onCurrentRecipe by viewModel.onCurrentRecipe.collectAsState()
    val onRecipeExtraInfo by viewModel.onRecipeExtraInfo.collectAsState()

    if (onCurrentRecipe == null) {
        // TODO: Show error
    } else {
        RecipeDetailsTemplate(
            recipe = onCurrentRecipe!!,
            recipeExtraInfo = onRecipeExtraInfo?.getOrNull(),
            onNavigateBackClick = onNavigateBackClick,
            onMapClick = { onMapClick(onRecipeExtraInfo?.getOrNull()?.location) }
        )
    }

    if (onRecipeExtraInfo?.isFailure == true) {
        AlertDialog(
            onDismissRequest = { /* Empty due there is no actions to do */ },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            ),
            title = { Text(stringResource(R.string.label_error)) },
            text = {
                Text(stringResource(R.string.error_something_went_wrong))
                if (BuildConfig.DEBUG) {
                    Text(onRecipeExtraInfo?.exceptionOrNull().toString())
                }
            },
            confirmButton = {
                Button(onClick = { viewModel.fetchDetails() }) {
                    Text(text = stringResource(R.string.btn_retry))
                }
            },
            dismissButton = {
                OutlinedButton(onClick = onNavigateBackClick, border = null) {
                    Text(text = "Close and back")
                }
            }
        )
    }
}
