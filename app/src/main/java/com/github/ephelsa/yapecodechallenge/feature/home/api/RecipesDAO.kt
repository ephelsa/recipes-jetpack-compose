package com.github.ephelsa.yapecodechallenge.feature.home.api

import com.github.ephelsa.yapecodechallenge.feature.home.data.model.Recipe
import com.github.ephelsa.yapecodechallenge.shared.data.model.DomainMapper
import com.google.gson.annotations.SerializedName

data class RecipesDAO(
    @SerializedName("recipes")
    val recipes: List<RecipeDAO>
) : DomainMapper<List<Recipe>> {

    override fun asDomainModel(): List<Recipe> = recipes.map(RecipeDAO::asDomainModel)

    data class RecipeDAO(
        @SerializedName("id")
        val id: Int,

        @SerializedName("name")
        val name: String,

        @SerializedName("ingredients")
        val ingredients: List<String>,

        @SerializedName("image_uri")
        val imageUrl: String,
    ) : DomainMapper<Recipe> {
        override fun asDomainModel(): Recipe = Recipe(
            id = id.toString(),
            name = name,
            imagePath = imageUrl,
            ingredients = ingredients,
        )
    }
}
