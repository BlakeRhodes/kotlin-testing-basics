package com.calderasoftware.recipe.models

class Ingredient(
    val name:String,
    val unitPrice: Double,
    val unitCalories: Double,
    val unit: String,
) {
    fun cost(units: Double): Double = unitPrice * units
    fun calories(units: Double): Double = unitCalories * units

    class Builder(
        name:String = "",
        unitPrice: Double = 0.0,
        unitCalories: Double = 0.0,
        unit: String = "unit",
    ){
        private val values : MutableMap<String, Any>

        init {
            values = mutableMapOf(
                "name" to name,
                "unitPrice" to unitPrice,
                "unitCalories" to unitCalories,
                "unit" to unit
            )
        }

        fun assign(field: String, value: Any): Builder = apply {
            values[field] = value
        }

        fun build(): Ingredient = Ingredient(
            name = values["name"] as String,
            unitPrice = values["unitPrice"] as Double,
            unitCalories = values["unitCalories"] as Double,
            unit = values["unit"] as String,
        )
    }
}