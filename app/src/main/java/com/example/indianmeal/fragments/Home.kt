package com.example.indianmeal.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.indianmeal.adapters.HomeAdabter
import com.example.indianmeal.data.DataManeger
import com.example.indianmeal.data.HomeItem
import com.example.indianmeal.databinding.FragmentHomeBinding
import com.example.indianmeal.util.CsvParser
import com.example.indianmeal.util.ItemType
import java.io.BufferedReader
import java.io.InputStreamReader


class Home : BaseFragment<FragmentHomeBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate

    override fun setup() {
        val list = listOf<HomeItem>(
            HomeItem("puplar meals",ItemType.ITEM_FOOD_FLIPER,DataManeger.listOfMeals.shuffled()),
            HomeItem("puplar meals", ItemType.ITEM_FOOD, DataManeger.listOfMeals.shuffled()),
            HomeItem("puplar meals", ItemType.ITEM_FOOD, DataManeger.listOfMeals.shuffled()),
        )
        binding.homeRecyclerView.adapter = HomeAdabter(list)


    }


}
