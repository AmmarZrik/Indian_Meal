package com.example.indianmeal.data

class DataManeger {
    val listOfMeals= mutableListOf<Meals>()
    fun addMeal(meal:Meals){
        listOfMeals.add(meal)
    }
}