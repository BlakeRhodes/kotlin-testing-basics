package com.calderasoftware.recipe.services

import com.calderasoftware.recipe.repositories.RecipeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrderService(
    @Autowired private val recipeRepository: RecipeRepository,
) {
    fun total(items: List<String>): Double = recipeRepository.findAllById(items)
        .sumOf {
            it.cost()
        }
}