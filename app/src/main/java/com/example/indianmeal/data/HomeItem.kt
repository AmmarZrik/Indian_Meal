package com.example.indianmeal.data

import com.example.indianmeal.util.ItemType

data class HomeItem(
val title:String,
val itemType:ItemType,
val listItem: List<Meals>,
)
