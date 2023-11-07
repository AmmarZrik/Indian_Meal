package com.example.indianmeal.fragments

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.indianmeal.HomeActivity
import com.example.indianmeal.data.Constants
import com.example.indianmeal.databinding.FragmentAboutBinding
import com.example.indianmeal.databinding.FragmentStartpageBinding
import com.example.indianmeal.handler
import com.example.indianmeal.util.Functions


class StartPage : BaseFragment<FragmentStartpageBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentStartpageBinding
        get() = FragmentStartpageBinding::inflate

    override fun setup() {
        binding.getStartButton.setOnClickListener {
            val shared=this.context?.getSharedPreferences(Constants.KEY_SHARED_PREFRENCES2,Activity.MODE_PRIVATE)
            shared?.edit()?.putBoolean(Constants.booleanKey,true)?.commit()
            Functions.setFragment(this,SplashScreen())
            handler.postDelayed({Functions.setFragment(this,Home())},2000)

        }
  }
}