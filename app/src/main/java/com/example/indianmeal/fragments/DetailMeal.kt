package com.example.indianmeal.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.indianmeal.databinding.FragmentDetailmealBinding

class DetailMeal : BaseFragment<FragmentDetailmealBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailmealBinding
        get() = FragmentDetailmealBinding::inflate

    override fun setup() {
    }
}