package com.calderasoftware.recipe.services

import com.calderasoftware.recipe.models.Ingredient
import com.calderasoftware.recipe.models.Recipe
import com.calderasoftware.recipe.repositories.RecipeRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever

internal class OrderServiceTest {

    @Mock
    lateinit var recipeRepository: RecipeRepository

    @InjectMocks
    lateinit var orderService: OrderService

    private val ingredient = Ingredient.Builder(
        name = "ingredient",
        unitPrice = 2.0,
        unitCalories = 2.0,
        unit = "ounces",
    ).build()

    private val recipe = Recipe.Builder(
        name = "recipe",
        markup = .20,
        ingredients = listOf(ingredient to 3.0),
    ).build()

    @BeforeEach
    fun setUp(){
        MockitoAnnotations.openMocks(this)
    }

    // TODO: Example 5
    // Using Mocks
    @Test
    fun `total should return the total for the order`() {
        whenever(recipeRepository.findAll(listOf("a")))
            .thenReturn(listOf(recipe))

        val result = orderService.total(listOf("a"))

        assertEquals(6.0, result)
    }
}