package com.example.indianmeal.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.indianmeal.HomeActivity
import com.example.indianmeal.adapters.HomeAdabter
import com.example.indianmeal.adapters.LovelyMealsAdapter
import com.example.indianmeal.data.DataManeger
import com.example.indianmeal.data.HomeItem
import com.example.indianmeal.databinding.FragmentLovelyMealsBinding
import com.example.indianmeal.fragments.BaseFragment
import com.example.indianmeal.util.ItemType

class LovelyMeals : BaseFragment<FragmentLovelyMealsBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentLovelyMealsBinding
        get() = FragmentLovelyMealsBinding::inflate

    override fun setup() {
        (this@LovelyMeals.context as HomeActivity).checkFragment(this)
        val list= listOf(HomeItem("",ItemType.LOVELY_FOOD))
        binding.recyclerView.adapter=HomeAdabter(list)

    }
}