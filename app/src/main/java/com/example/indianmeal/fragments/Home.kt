package com.example.indianmeal.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.indianmeal.HomeActivity
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
        (this@Home.context as HomeActivity).checkFragment(this)
        val list = listOf<HomeItem>(
            HomeItem("Random meals",ItemType.ITEM_FOOD_FLIPER,),
            HomeItem("popular meals", ItemType.ITEM_FOOD, ),
            HomeItem("All meals", ItemType.ITEM_FOOD,),
        )
        binding.homeRecyclerView.adapter=HomeAdabter(list)



    }


}
