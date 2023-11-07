package com.example.indianmeal.util

interface OnClickItem {
    fun onItemClick(position: Int  ,
                    imageUrl: String,
                    price :String,
                    totalTime: String,
                    cuisine: String,
                    preparation: String,
                    mealName: String,
                  )
    fun onloveItemClick(position: Int ,
                        imageUrl: String,
                        price :String,
                         totalTime: String,
                         cuisine: String,
                         preparation: String,
                         mealName: String,
    )
}