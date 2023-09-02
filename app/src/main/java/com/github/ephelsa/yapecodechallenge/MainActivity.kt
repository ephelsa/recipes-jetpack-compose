package com.github.ephelsa.yapecodechallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.viewModelFactory
import com.github.ephelsa.yapecodechallenge.feature.home.HomeScreen
import com.github.ephelsa.yapecodechallenge.feature.home.HomeViewModel
import com.github.ephelsa.yapecodechallenge.feature.home.data.repository.RepositoryModule
import com.github.ephelsa.yapecodechallenge.shared.theme.YapeCodeChallengeTheme

class MainActivity : ComponentActivity() {
    private val homeViewModel: HomeViewModel by viewModels {
        viewModelFactory {
            addInitializer(HomeViewModel::class) {
                HomeViewModel(RepositoryModule.recipeRepository)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YapeCodeChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen(viewModel = homeViewModel)
                }
            }
        }
    }
}
