package com.github.ephelsa.yapecodechallenge.feature.details

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.github.ephelsa.yapecodechallenge.feature.home.data.model.Recipe
import com.github.ephelsa.yapecodechallenge.shared.utils.NavConst
import com.github.ephelsa.yapecodechallenge.shared.utils.setYapeContent

class DetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recipe = intent.extras?.getParcelable<Recipe>(NavConst.Details.RecipeResumeKey)

        setYapeContent {
        }
    }
}
