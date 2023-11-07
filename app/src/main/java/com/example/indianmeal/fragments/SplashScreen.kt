package com.example.indianmeal.fragments


import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.example.indianmeal.HomeActivity
import com.example.indianmeal.R
import com.example.indianmeal.data.Constants
import com.example.indianmeal.databinding.FragmentSplashScreenBinding
import com.example.indianmeal.handler
import com.example.indianmeal.util.Functions


class SplashScreen : BaseFragment<FragmentSplashScreenBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSplashScreenBinding
        get() = FragmentSplashScreenBinding::inflate

    override fun setup() {
        val anime1=AnimationUtils.loadAnimation(this.context , R.anim.splash_animation)
        val anime2=AnimationUtils.loadAnimation(this.context , R.anim.title_animation)


        binding.card.animation=anime1
        binding.titleLinear.animation=anime2

    }


}