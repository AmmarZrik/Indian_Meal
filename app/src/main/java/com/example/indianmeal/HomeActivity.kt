package com.example.indianmeal

import com.example.indianmeal.fragments.About
import com.example.indianmeal.fragments.LovelyMeals
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.indianmeal.data.Constants
import com.example.indianmeal.data.DataManeger
import com.example.indianmeal.databinding.ActivityMainBinding
import com.example.indianmeal.fragments.Home
import com.example.indianmeal.fragments.Search
import com.example.indianmeal.fragments.SplashScreen
import com.example.indianmeal.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception


var doubleCliclBack = false
val handler = Handler()
val homeFragment = Home()
val aboutFragment = About()
val searchFragment = Search()
val lovelyFragment = LovelyMeals()

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    private fun setup() {

        val splashScreen = SplashScreen()
        setFragment(splashScreen)
        replaceSplashScreen()

        navigateFragment()


    }

    private fun navigateFragment() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> setFragment(homeFragment)
                R.id.lovely -> setFragment(lovelyFragment)
                R.id.search -> setFragment(searchFragment)
                R.id.about -> setFragment(aboutFragment)
                else -> setFragment(homeFragment)
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun replaceSplashScreen() {
        handler.postDelayed(
            {   parseFile()
                setFragment(homeFragment)
                binding.bottomNavigation.visibility = View.VISIBLE
            },
            Constants.handlerTime
        )
    }

    private fun setFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment, fragment)

        transaction.commit()
        if (fragment is SplashScreen) {
            binding.bottomNavigation.visibility = View.INVISIBLE
            fragmentManager.popBackStack()
        }

    }

    private fun parseFile() {
        val inputStream = assets.open("Indian_food.csv")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        val parser = CsvParser()



        
        buffer.forEachLine {
            val currentLine = parser.parse(it)
            DataManeger.addMeal(currentLine)}

                Log.i("Zz", DataManeger.listOfMeals.size.toString())




    }

    override fun onBackPressed() {
        if (doubleCliclBack)
            super.onBackPressed()
        doubleCliclBack = true
        Toast.makeText(this, "Click back again to exit", Toast.LENGTH_SHORT).show()
        handler.postDelayed({ doubleCliclBack = false }, Constants.handlerTime)
    }

}