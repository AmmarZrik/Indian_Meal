package com.example.indianmeal.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.indianmeal.adapters.LovelyMealsAdapter
import com.example.indianmeal.data.DataManeger
import com.example.indianmeal.data.Meals
import com.example.indianmeal.databinding.FragmentLovelyMealsBinding

class LovelyMeals : BaseFragment<FragmentLovelyMealsBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentLovelyMealsBinding
        get() = FragmentLovelyMealsBinding::inflate

    override fun setup() {
        adapter()
    }

    private fun adapter() {
        val rv_lovelymeal=binding.recyclerviewlovelymeals
        val listoflovelymeal=ArrayList<Meals>()
        val adapter= LovelyMealsAdapter(DataManeger.listOfMeals)
        rv_lovelymeal.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        rv_lovelymeal.adapter=adapter
    }
}