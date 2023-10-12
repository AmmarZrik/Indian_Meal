package com.example.indianmeal

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.window.SplashScreen
import androidx.fragment.app.Fragment
import com.example.indianmeal.databinding.ActivityMainBinding
import com.example.indianmeal.databinding.ActivityMainBinding.inflate

lateinit var binding :ActivityMainBinding

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    private fun setup() {
        val splashScreen= SplashScreen()
        changeFragment(splashScreen)

    }



    private fun changeFragment(fragment:Fragment){
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}