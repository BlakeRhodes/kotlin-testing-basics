package com.calderasoftware.recipe.repositories

import com.calderasoftware.recipe.models.Recipe
import org.springframework.stereotype.Repository

@Repository
class RecipeRepository {
    fun findAll(recipes: List<String>): List<Recipe> {
        TODO()
    }
}