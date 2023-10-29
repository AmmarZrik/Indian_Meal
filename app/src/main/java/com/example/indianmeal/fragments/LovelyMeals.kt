package com.example.indianmeal.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.indianmeal.databinding.FragmentLovelyMealsBinding
import com.example.indianmeal.fragments.BaseFragment

class LovelyMeals : BaseFragment<FragmentLovelyMealsBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentLovelyMealsBinding
        get() = FragmentLovelyMealsBinding::inflate

    override fun setup() {
    }
}