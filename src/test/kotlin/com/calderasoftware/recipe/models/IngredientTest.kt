package com.calderasoftware.recipe.models

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class IngredientTest {
    private lateinit var builder: Ingredient.Builder

    @BeforeEach
    fun setUp() {
        builder = Ingredient.Builder(
            unitPrice = 2.0
        )
    }
    // TODO: Example 1
    // 3 A's
    @Test
    fun `cost should return the product of the unitPrice and the number of units, single test`() {
       // Arrange
        val expected = 4.0
        val ingredient = builder.build()

        // Act
        val result = ingredient.cost(2.0)

        // Assert
        assertEquals(expected, result, "Cost for 2.0 units at 2.0 per unit should be 4.0")
    }

    // TODO: Example 2
    // Parameterized Testing
    @ParameterizedTest
    @CsvSource(
        "2.0,2.0,4.0",
        "1.5,4.0,6.0"
    )
    fun `calories should return the product of the unitPrice and the number of units`(
        unitCalories: Double,
        units: Double,
        expected: Double,
    ) {
        val ingredient = builder.assign("unitCalories", unitCalories)
            .build()

        val result = ingredient.calories(units)

        assertEquals(expected, result, "Calories for $units units at $unitCalories per unit should be $expected")
    }
}