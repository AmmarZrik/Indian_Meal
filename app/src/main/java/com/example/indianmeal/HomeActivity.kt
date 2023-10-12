package com.example.indianmeal

import android.opengl.Visibility
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import com.example.indianmeal.databinding.ActivityMainBinding
import com.example.indianmeal.fragments.SplashScreen
lateinit var binding :ActivityMainBinding
val handler= Handler()
val home=Home()
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    private fun setup() {
        val splashScreen=SplashScreen()

        setFragment(splashScreen)
        replaceSplashScreen()



    }

    private fun replaceSplashScreen() {
        handler.postDelayed({setFragment(home)
            binding.bottomNavigation.visibility= View.VISIBLE},
            2000)
    }

    private fun initial(){

    }



    private fun setFragment(fragment:Fragment){
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        if(fragment is SplashScreen)
            binding.bottomNavigation.visibility= View.INVISIBLE

    }
}