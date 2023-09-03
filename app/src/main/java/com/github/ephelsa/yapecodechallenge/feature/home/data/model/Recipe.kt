package com.github.ephelsa.yapecodechallenge.feature.home.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(
    val id: String,
    val name: String,
    val imagePath: String,
    val ingredients: List<String>,
): Parcelable
