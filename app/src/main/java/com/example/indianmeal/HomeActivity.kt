package com.example.indianmeal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import com.example.indianmeal.data.Constants
import com.example.indianmeal.data.DataManeger
import com.example.indianmeal.databinding.ActivityMainBinding
import com.example.indianmeal.fragments.Home
import com.example.indianmeal.fragments.SplashScreen
import com.example.indianmeal.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var binding :ActivityMainBinding
val handler= Handler()
val home= Home()
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
            Constants.handlerTime)
    }

    private fun parseFile(){

        val inputStream=assets.open("Indian_food.csv")
        val buffer =BufferedReader(InputStreamReader(inputStream))
        val parser=CsvParser()
        buffer.forEachLine {
        val currentLine =parser.parse(it)
            DataManeger().addMeal(currentLine)

        }
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