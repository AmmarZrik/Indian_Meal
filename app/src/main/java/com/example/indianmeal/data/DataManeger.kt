package com.example.indianmeal.data

object DataManeger {
    val listOfMeals= mutableListOf<Meals>()
    fun addMeal(meal:Meals){
        listOfMeals.add(meal)
    }
}