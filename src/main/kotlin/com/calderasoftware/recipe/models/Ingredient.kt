package com.calderasoftware.recipe.models

class Ingredient(
    val name: String,
    val unitPrice: Double,
    val unitCalories: Double,
    val unitOfMeasure: String,
) {
    fun cost(units: Double): Double = TODO("Example 1")
    fun calories(units: Double): Double = TODO("Example 2")

    class Builder(
        name: String = "",
        unitPrice: Double = 0.0,
        unitCalories: Double = 0.0,
        unitOfMeasure: String = "unit",
    ) {
        private val values: MutableMap<String, Any>

        init {
            values = mutableMapOf(
                "name" to name,
                "unitPrice" to unitPrice,
                "unitCalories" to unitCalories,
                "unitOfMeasure" to unitOfMeasure
            )
        }

        fun assign(field: String, value: Any): Builder = apply {
            values[field] = value
        }

        fun build(): Ingredient = Ingredient(
            name = values["name"] as String,
            unitPrice = values["unitPrice"] as Double,
            unitCalories = values["unitCalories"] as Double,
            unitOfMeasure = values["unitOfMeasure"] as String,
        )
    }
}