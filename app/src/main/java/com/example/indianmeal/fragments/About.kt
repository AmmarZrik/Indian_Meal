package com.example.indianmeal.fragments

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.indianmeal.databinding.FragmentAboutBinding


class About : BaseFragment<FragmentAboutBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentAboutBinding
        get() = FragmentAboutBinding::inflate

    override fun setup() {
        binding.apply {
            titleIndianFood.setOnClickListener {
                val i= Intent(context, StartPageFragment::class.java)
                startActivity(i)
            }
        }
    }
}