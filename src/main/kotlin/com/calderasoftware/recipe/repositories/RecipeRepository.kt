package com.calderasoftware.recipe.repositories

import com.calderasoftware.recipe.models.Recipe
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface RecipeRepository : MongoRepository<Recipe, String>