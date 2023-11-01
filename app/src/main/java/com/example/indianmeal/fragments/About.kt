package com.example.indianmeal.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.indianmeal.R.drawable
import com.example.indianmeal.databinding.FragmentAboutBinding


class About : BaseFragment<FragmentAboutBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentAboutBinding
        get() = FragmentAboutBinding::inflate

    override fun setup() {
        fliper()
  }

    private fun fliper() {
        val fliperone= listOf(

            drawable.food5,
            drawable.start,
            drawable.food4,
            drawable.food6,

        )
        val flipertwo= listOf(
            drawable.spices2,
            drawable.spices,
            drawable.spices1,
        )
        binding.apply {
            image1.setImageResource(fliperone[0])
            image2.setImageResource(fliperone[1])
            image3.setImageResource(fliperone[2])
            image4.setImageResource(fliperone[3])
            image5.setImageResource(flipertwo[0])
            image6.setImageResource(flipertwo[1])
            image7.setImageResource(flipertwo[2])
        }


    }
}