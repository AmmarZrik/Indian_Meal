package com.example.indianmeal.data

import com.example.indianmeal.util.SearchItemType

data class SearchItem(
    val type: SearchItemType,
    val listItem: List<Meals>
)
