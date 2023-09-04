package com.github.ephelsa.yapecodechallenge.feature.home.utils

import com.github.ephelsa.yapecodechallenge.feature.home.data.model.Recipe
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldHaveSize

private val recipes = listOf(
    Recipe(
        id = "1",
        name = "Banana mango eLote Pizza",
        imagePath = "",
        ingredients = listOf(),
    ),
    Recipe(
        id = "2",
        name = "Kana fandango",
        imagePath = "",
        ingredients = listOf(),
    ),
    Recipe(
        id = "3",
        name = "Pizza",
        imagePath = "",
        ingredients = listOf(),
    ),
)

internal class ByNameTest : BehaviorSpec({
    given("a query") {
        `when`("The query is case sensitive") {
            and("exists in recipes") {
                then("Should be found") {
                    val query = "Pizza"

                    FindRecipeStrategy.find(ByName(query, recipes)) shouldHaveSize 2
                }
            }
        }

        `when`("The query is not case sensitive") {
            and("exists in recipes") {
                then("Should be found") {
                    val query = "piZza"

                    FindRecipeStrategy.find(ByName(query, recipes)) shouldHaveSize 2
                }
            }
        }

        `when`("Does not exist") {
            then("Should return an empty array") {
                val query = "avocado"

                FindRecipeStrategy.find(ByName(query, recipes)) shouldHaveSize 0
            }
        }
    }
})