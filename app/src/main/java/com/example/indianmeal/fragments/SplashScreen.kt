package com.example.indianmeal.fragments


import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.indianmeal.databinding.FragmentSplashScreenBinding


class SplashScreen : BaseFragment<FragmentSplashScreenBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSplashScreenBinding
        get() = FragmentSplashScreenBinding::inflate

    override fun setup() {

    }


}