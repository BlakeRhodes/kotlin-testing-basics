package com.calderasoftware.recipe.services

import com.calderasoftware.recipe.models.Ingredients
import com.calderasoftware.recipe.models.Recipe

class DrinkCardService {
    private val directionsFormatter: DirectionsFormatter = DirectionsFormatter()
    private val ingredientFormatter: IngredientFormatter = IngredientFormatter()

    fun format(recipe: Recipe): String {
        val card = mutableListOf(edge)
        card.add("* ${recipe.name}".pad())
        card.add("* Price: $%.2f".format(recipe.price()).pad())
        card.add("* Cal: ${recipe.calories()}".pad())
        card.add(blank)
        ingredientFormatter.format(recipe.ingredients).map {
            card.add(it.pad())
        }
        card.add(blank)
        directionsFormatter.format(recipe.directions).map {
            card.add(it.pad())
        }
        card.add(edge)

        return card.joinToString(
            separator = ""
        )
    }

    companion object {
        const val edge = "* * * * * * * * * * * * * * * * * * * * * * * *\n"
        const val blank = "*                                             *\n"
        fun String.pad() = this.padEnd(46, ' ') + "*\n"
    }
}

class DirectionsFormatter {
    fun format(directions: List<String>): List<String> {
        val formatted = mutableListOf("* Directions")
        for(i in 0 .. directions.lastIndex){
            formatted.add("* ${i+1}. ${directions[i]}")
        }
        return formatted
    }
}

class IngredientFormatter {
    fun format(ingredients: Ingredients): List<String>{
        val formatted = mutableListOf("* Ingredients")
        for(i in 0 .. ingredients.lastIndex){
            formatted.add(
                "* ${ingredients[i].second} ${ingredients[i].first.unit} ${ingredients[i].first.name}"
            )
        }
        return formatted
    }
}
