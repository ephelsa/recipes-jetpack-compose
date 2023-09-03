package com.github.ephelsa.yapecodechallenge.feature.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.viewModelFactory
import com.github.ephelsa.yapecodechallenge.feature.details.DetailsActivity
import com.github.ephelsa.yapecodechallenge.feature.home.components.screens.HomeScreen
import com.github.ephelsa.yapecodechallenge.feature.home.data.repository.RepositoryModule
import com.github.ephelsa.yapecodechallenge.shared.utils.NavConst
import com.github.ephelsa.yapecodechallenge.shared.utils.setYapeContent
import com.github.ephelsa.yapecodechallenge.shared.utils.startComponentActivity

class HomeActivity : ComponentActivity() {
    private val homeViewModel: HomeViewModel by viewModels {
        viewModelFactory {
            addInitializer(HomeViewModel::class) {
                HomeViewModel(RepositoryModule.recipeRepository)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setYapeContent {
            HomeScreen(viewModel = homeViewModel) { recipe ->
                startComponentActivity(DetailsActivity::class.java) {
                    putParcelable(NavConst.Details.RecipeResumeKey, recipe)
                }
            }
        }
    }
}
