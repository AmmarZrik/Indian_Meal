package com.example.indianmeal.fragments


import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.indianmeal.data.Constants
import com.example.indianmeal.databinding.FragmentSplashScreenBinding
import com.example.indianmeal.handler
import com.example.indianmeal.util.Functions


class SplashScreen : BaseFragment<FragmentSplashScreenBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSplashScreenBinding
        get() = FragmentSplashScreenBinding::inflate

    override fun setup() {


    }


}