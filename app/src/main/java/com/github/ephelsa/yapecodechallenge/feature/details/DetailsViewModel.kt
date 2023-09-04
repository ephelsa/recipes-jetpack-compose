package com.github.ephelsa.yapecodechallenge.feature.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.ephelsa.yapecodechallenge.feature.details.data.model.RecipeExtraInfo
import com.github.ephelsa.yapecodechallenge.feature.details.data.repository.DetailsRepository
import com.github.ephelsa.yapecodechallenge.feature.home.data.model.Recipe
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val detailsRepository: DetailsRepository,
) : ViewModel() {
    var onCurrentRecipe = MutableStateFlow<Recipe?>(null)
        private set

    var onNullRecipeReceivedError = MutableStateFlow<Unit?>(null)
        private set

    var onRecipeExtraInfo = MutableStateFlow<Result<RecipeExtraInfo>?>(null)
        private set

    fun setRecipe(recipe: Recipe?) {
        if (recipe == null) {
            onNullRecipeReceivedError.value = Unit
            return
        }

        onCurrentRecipe.value = recipe
        fetchDetails()
    }

    fun fetchDetails() = viewModelScope.launch {
        // Useful to retry
        onRecipeExtraInfo.value = null

        if (onCurrentRecipe.value?.id.isNullOrEmpty()) {
            cancel("ID is null")
        } else {
            val result = detailsRepository.getRecipeExtraInfo(onCurrentRecipe.value!!.id)
            onRecipeExtraInfo.value = result
        }
    }
}