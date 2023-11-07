package com.example.indianmeal

import android.app.Activity
import com.example.indianmeal.fragments.About
import com.example.indianmeal.fragments.LovelyMeals
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.transition.Fade
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.indianmeal.data.Constants
import com.example.indianmeal.data.DataManeger
import com.example.indianmeal.databinding.ActivityMainBinding
import com.example.indianmeal.fragments.Home
import com.example.indianmeal.fragments.MealDetails
import com.example.indianmeal.fragments.Search
import com.example.indianmeal.fragments.SplashScreen
import com.example.indianmeal.fragments.StartPage
import com.example.indianmeal.fragments.WebView
import com.example.indianmeal.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader
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
        if(getSharedPreferences(Constants.KEY_SHARED_PREFRENCES2,Activity.MODE_PRIVATE).getBoolean(Constants.booleanKey,false))
        {setFragment(splashScreen)
            replaceSplashScreen() }
        else{
            parseFile()
        setFragment(StartPage())

        }
        navigateFragment()



    }

     fun checkFragment(fragment: Fragment) {
        if(fragment is Home||fragment is Search ||fragment is LovelyMeals||fragment is About)
            binding.bottomNavigation.visibility = View.VISIBLE
        else
            binding.bottomNavigation.visibility = View.GONE

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

     fun replaceSplashScreen() {
        handler.postDelayed(
            {   parseFile()
                DataManeger.listOfLovelyMeals.addAll(DataManeger.getLovelyList(this))
                setFragment(homeFragment)
            },
            Constants.handlerTime
        )
    }

    fun setFragment(fragment: Fragment) {
        val exitTransition = Fade()
        exitTransition.duration = 300
        fragment.exitTransition = exitTransition

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment, fragment)
        transaction.commit()
        checkFragment(fragment)




    }

    private fun parseFile() {
        val inputStream = assets.open("Indian_food.csv")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        val parser = CsvParser()
        buffer.forEachLine {
            val currentLine = parser.parse(it)
            DataManeger.addMeal(currentLine)}

                Log.i("Zz", DataManeger.listOfMeals.toString())




    }

    override fun onBackPressed() {

            when (supportFragmentManager.findFragmentById(R.id.fragment) ) {
                is Home ->{   if (doubleCliclBack) { super.onBackPressed()
            }
                else{
                    Toast.makeText(this,"Click Back Again..", Toast.LENGTH_SHORT).show()
                    doubleCliclBack = true
                    handler.postDelayed({ doubleCliclBack = false }, Constants.handlerTime)
                }}


                is WebView  ->{ super.onBackPressed()}
                is MealDetails ->{
                    binding.bottomNavigation.visibility=View.VISIBLE
                    super.onBackPressed()}

                else -> {
                    setFragment(Home())
                    binding.bottomNavigation.selectedItemId=R.id.home}
            }


    }

    override fun onStop() {
        super.onStop()
        DataManeger.saveLovelyList(DataManeger.listOfLovelyMeals,this)

    }
}