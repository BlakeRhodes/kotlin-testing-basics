package com.calderasoftware.recipe.services

import com.calderasoftware.recipe.models.Ingredient
import com.calderasoftware.recipe.models.Recipe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class DrinkCardServiceTest{
    lateinit var drinkCardService: DrinkCardService

    val ingredients = listOf(
        Ingredient.Builder(
            name = "rum",
            unitPrice = .90,
            unitCalories = 65.0,
            unit = "ounces"
        ).build() to 3.0,
        Ingredient.Builder(
            name = "coke",
            unitPrice = .05,
            unitCalories = 10.0,
            unit = "ounces"
        ).build() to 6.0,
    )

    val recipe = Recipe.Builder(
        name = "rum volcano",
        markup = .20,
        ingredients = ingredients,
        directions = listOf(
            "Add ingredients to shaker",
            "Shake",
            "Pour into glass",
            "Garnish with solid gold tiny umbrella"
        )
    ).build()

    @BeforeEach
    fun setUp(){
        drinkCardService = DrinkCardService()
    }

    // TODO: Example 6
    // Contravariant Test
    @Test
    fun `format should make a sweet drink card for patrons to read`(){
        val expected = """
            * * * * * * * * * * * * * * * * * * * * * * * *
            * rum volcano                                 *
            * Price: $3.60                                *
            * Cal: 255.0                                  *
            *                                             *
            * Ingredients                                 *
            * 3.0 ounces rum                              *
            * 6.0 ounces coke                             *
            *                                             *
            * Directions                                  *
            * 1. Add ingredients to shaker                *
            * 2. Shake                                    *
            * 3. Pour into glass                          *
            * 4. Garnish with solid gold tiny umbrella    *
            * * * * * * * * * * * * * * * * * * * * * * * *
            
        """.trimIndent()

        val result = drinkCardService.format(recipe)

        assertEquals(expected, result)
    }


}