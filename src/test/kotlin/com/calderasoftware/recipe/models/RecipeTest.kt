package com.calderasoftware.recipe.models

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class RecipeTest {

    private lateinit var builder: Recipe.Builder

    @BeforeEach
    fun setUp() {
        builder = Recipe.Builder()
    }
    // TODO: Example 3
    // Test is too specific
    @Test
    fun `cost should return the cost of the drink based on the ingredients`() {
        val expected = 30.0

        val recipe = builder.assign(
            "ingredients",
            listOf(
                Ingredient.Builder(unitPrice = 1.0).build() to 1.0,
                Ingredient.Builder(unitPrice = 2.0).build() to 2.0,
                Ingredient.Builder(unitPrice = 3.0).build() to 3.0,
                Ingredient.Builder(unitPrice = 4.0).build() to 4.0,
            )
        ).build()

        val result = recipe.cost()

        assertEquals(expected, result, "Total cost of recipe should be 30.0, it was $result")
    }

    // TODO: Example 4
    // Method Source
    @ParameterizedTest
    @MethodSource("calories")
    fun `calories should return the total calories in the recipe`(
        ingredients: List<Pair<Ingredient, Double>>,
        expected: Double,
    ) {
        val recipe = builder.assign("ingredients", ingredients).build()

        val result = recipe.calories()

        assertEquals(expected, result)
    }

    companion object {
        @JvmStatic
        fun calories(): Stream<Arguments?>? {
            return Stream.of(
                arguments(
                    listOf(
                        Ingredient.Builder(unitCalories = 1.0).build() to 1.0,
                        Ingredient.Builder(unitCalories = 2.0).build() to 2.0,
                        Ingredient.Builder(unitCalories = 3.0).build() to 3.0,
                    ), 14.0
                ),
                arguments(
                    listOf(
                        Ingredient.Builder(unitCalories = 1.5).build() to 1.0,
                        Ingredient.Builder(unitCalories = 2.5).build() to 2.0,
                        Ingredient.Builder(unitCalories = 3.0).build() to 3.5,
                    ), 17.0
                ),
            )
        }
    }
}