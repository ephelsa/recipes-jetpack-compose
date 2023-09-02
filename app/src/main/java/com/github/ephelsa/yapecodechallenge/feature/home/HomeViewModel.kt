package com.github.ephelsa.yapecodechallenge.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.ephelsa.yapecodechallenge.feature.home.data.model.Recipe
import com.github.ephelsa.yapecodechallenge.feature.home.data.repository.RecipeRepository
import com.github.ephelsa.yapecodechallenge.feature.home.utils.ByIngredient
import com.github.ephelsa.yapecodechallenge.feature.home.utils.ByName
import com.github.ephelsa.yapecodechallenge.feature.home.utils.FindRecipeStrategy
import com.github.ephelsa.yapecodechallenge.feature.home.utils.Options
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

internal class HomeViewModel(
    private val recipeRepository: RecipeRepository,
) : ViewModel() {

    val filterOptions = Options.filterOptions
    val placeholderOptions = Options.placeholderOptions

    var onRecipesLoading = MutableStateFlow(false)
        private set

    var onRecipesResult = MutableStateFlow<Result<List<Recipe>>?>(null)
        private set

    var onRecipesSearchResult = MutableStateFlow<List<Recipe>?>(null)
        private set

    var onSearchText = MutableStateFlow("")
        private set

    var onFilterSelected = MutableStateFlow(filterOptions[0])
        private set

    init {
        fetchRecipesList()
    }

    fun fetchRecipesList() {
        viewModelScope.launch {
            onRecipesLoading.value = true
            onRecipesResult.value = recipeRepository.fetchRecipesList()
            onRecipesLoading.value = false
        }
    }

    fun changeCurrentFilter(filter: String) {
        onFilterSelected.value = filter
        search()
    }

    fun changeSearchQuery(query: String) {
        onSearchText.value = query
        search()
    }

    private fun search() {
        val query = onSearchText.value.trim()
        val recipesList = onRecipesResult.value?.getOrNull() ?: listOf()

        if (query.isEmpty()) {
            onRecipesSearchResult.value = null
            return
        }

        onRecipesSearchResult.value = when (onFilterSelected.value) {
            filterOptions[0] -> FindRecipeStrategy.find(ByName(query, recipesList))
            else -> FindRecipeStrategy.find(ByIngredient(query, recipesList))
        }
    }
}
