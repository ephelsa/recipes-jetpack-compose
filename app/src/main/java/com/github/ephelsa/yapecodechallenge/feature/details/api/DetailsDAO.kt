package com.github.ephelsa.yapecodechallenge.feature.details.api

import com.github.ephelsa.yapecodechallenge.feature.details.data.model.RecipeExtraInfo
import com.github.ephelsa.yapecodechallenge.shared.data.model.DomainMapper
import com.google.gson.annotations.SerializedName

data class DetailsDAO(
    @SerializedName("description")
    val description: String,

    @SerializedName("location")
    val location: String
) : DomainMapper<RecipeExtraInfo> {
    override fun asDomainModel(): RecipeExtraInfo = RecipeExtraInfo(
        description = description,
        location = location
    )
}
