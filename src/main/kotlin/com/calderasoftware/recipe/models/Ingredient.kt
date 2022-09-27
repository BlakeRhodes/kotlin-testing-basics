package com.calderasoftware.recipe.models

class Ingredient(
    val name: String,
    val unitCost: Double,
    val unitCalories: Double,
    val unitOfMeasure: String,
) {
    fun cost(units: Double): Double = TODO("Example 1")
    fun calories(units: Double): Double = TODO("Example 2")

    class Builder(
        name: String = "",
        unitCost: Double = 0.0,
        unitCalories: Double = 0.0,
        unitOfMeasure: String = "unit",
    ) {
        private val values: MutableMap<String, Any>

        init {
            values = mutableMapOf(
                "name" to name,
                "unitCost" to unitCost,
                "unitCalories" to unitCalories,
                "unitOfMeasure" to unitOfMeasure
            )
        }

        fun assign(field: String, value: Any): Builder = apply {
            values[field] = value
        }

        fun build(): Ingredient = Ingredient(
            name = values["name"] as String,
            unitCost = values["unitCost"] as Double,
            unitCalories = values["unitCalories"] as Double,
            unitOfMeasure = values["unitOfMeasure"] as String,
        )
    }
}