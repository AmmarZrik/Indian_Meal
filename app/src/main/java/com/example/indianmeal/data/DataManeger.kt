package com.example.indianmeal.data

import android.app.Activity
import android.content.Context
import com.example.indianmeal.data.Constants.SHARED_NAME
import com.example.indianmeal.fragments.LovelyMeals
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object DataManeger {
    val listOfMeals= mutableListOf<Meals>()
    fun addMeal(meal:Meals){
        listOfMeals.add(meal)
    }
    val listOfLovelyMeals= mutableListOf<Meals>()
    fun addLovelyMeal(meal:Meals){
        listOfLovelyMeals.add(meal)

    }
    fun removeLovelyMeal(meal: Int){
        listOfLovelyMeals.removeAt(meal)
    }

    fun saveLovelyList(list:List<Meals>,context: Context){
    val sharedPreferences=context.getSharedPreferences(SHARED_NAME,Activity.MODE_PRIVATE)
    val gson= Gson()
    val json=gson.toJson(list)
    sharedPreferences.edit().putString(Constants.KEY_SHARED_PREFRENCES,json).commit()
    }
    fun getLovelyList(context: Context?):List<Meals>{
        val sharedPreferences=context?.getSharedPreferences(SHARED_NAME,Activity.MODE_PRIVATE)
        val gson= Gson()
        val json=sharedPreferences?.getString(Constants.KEY_SHARED_PREFRENCES,"")
        val type =object :TypeToken<List<Meals>>() {}.type
        return gson.fromJson(json, type) ?: emptyList()

    }
}