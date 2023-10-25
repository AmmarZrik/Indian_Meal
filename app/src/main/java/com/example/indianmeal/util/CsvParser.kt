package com.example.indianmeal.util

import com.example.indianmeal.data.Constants
import com.example.indianmeal.data.Meals

class CsvParser {
    fun parse(line: String): Meals {
        val tokens:List<String> = line.split(',')
        return Meals(
            mealName = tokens[Constants.mealName],
            ingredients = tokens[Constants.ingredients],
            totalTime = tokens[Constants.totalTime],
            cuisine = tokens[Constants.cuisine],
            preparation = tokens[Constants.preparation],
            webUrl = tokens[Constants.webUrl],
            components = tokens[Constants.components],
            imageUrl = tokens[Constants.imageUrl],
            price =tokens[Constants.price]
        )
    }
}