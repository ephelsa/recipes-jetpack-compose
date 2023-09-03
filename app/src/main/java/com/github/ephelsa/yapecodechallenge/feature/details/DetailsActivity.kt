package com.github.ephelsa.yapecodechallenge.feature.details

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.viewModelFactory
import com.github.ephelsa.yapecodechallenge.R
import com.github.ephelsa.yapecodechallenge.di.RepositoryModule
import com.github.ephelsa.yapecodechallenge.feature.details.components.screens.RecipeDetailsScreen
import com.github.ephelsa.yapecodechallenge.feature.home.data.model.Recipe
import com.github.ephelsa.yapecodechallenge.shared.utils.NavConst
import com.github.ephelsa.yapecodechallenge.shared.utils.setYapeContent
import kotlinx.coroutines.flow.onEach

class DetailsActivity : ComponentActivity() {
    private val viewModel: DetailsViewModel by viewModels {
        viewModelFactory {
            addInitializer(DetailsViewModel::class) {
                DetailsViewModel(RepositoryModule.detailsRepository())
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setRecipe()
        handleOnNullRecipeReceiveError()

        setYapeContent {
            RecipeDetailsScreen(viewModel = viewModel, onNavigateBackClick = { finish() })
        }
    }

    private fun setRecipe() {
        val recipe = intent.extras?.getParcelable<Recipe>(NavConst.Details.RecipeResumeKey)
        viewModel.setRecipe(recipe = recipe)
    }

    private fun handleOnNullRecipeReceiveError() {
        viewModel.onNullRecipeReceivedError.onEach {
            Toast.makeText(
                this,
                resources.getString(R.string.error_recipe_not_passed),
                Toast.LENGTH_LONG
            ).show()
            finish()
        }
    }
}
