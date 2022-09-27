package com.calderasoftware.recipe.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Recipe(
    @Id
    val id: String? = null,
    val name: String = "",
    val markup: Double = 0.0,
    val ingredients: List<Pair<Ingredient, Double>> = emptyList(),
    val directions: List<String> = emptyList(),
) {
    fun cost(): Double = ingredients.sumOf {
        it.first.cost(it.second)
    }

    fun calories(): Double = ingredients.sumOf {
        it.first.calories(it.second)
    }

    fun price(): Double = cost() * (1.0 + markup)

    class Builder(
        name: String = "",
        markup: Double = 0.0,
        ingredients: List<Pair<Ingredient, Double>> = emptyList(),
        directions: List<String> = emptyList(),
    ) {
        private val values: MutableMap<String, Any>

        init {
            values = mutableMapOf(
                "name" to name,
                "markup" to markup,
                "ingredients" to ingredients,
                "directions" to directions
            )
        }

        fun assign(field: String, value: Any): Builder = apply {
            values[field] = value
        }

        fun build(): Recipe = Recipe(
            name = values["name"] as String,
            markup = values["markup"] as Double,
            ingredients = values["ingredients"] as List<Pair<Ingredient, Double>>,
            directions = values["directions"] as List<String>,
        )
    }
}