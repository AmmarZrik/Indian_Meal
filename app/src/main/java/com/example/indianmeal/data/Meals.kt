package com.example.indianmeal.data


data class Meals(
    val mealName: String,
    val ingredients: String,
    val totalTime: String,
    val cuisine: String,
    val preparation: String,
    val webUrl: String,
    val components: String,
    val imageUrl: String,
    val price :String,
    val id: Int = setId(),
    var lovely:Boolean=false,

){
    companion object{
        var id =0

        fun setId():Int{id++
            return id}
    }
}
