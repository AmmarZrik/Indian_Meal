package com.example.indianmeal.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.indianmeal.HomeActivity
import com.example.indianmeal.R
import com.example.indianmeal.data.Constants
import com.example.indianmeal.data.DataManeger
import com.example.indianmeal.databinding.FragmentAboutBinding
import com.example.indianmeal.databinding.FragmentDetailmealBinding
import com.example.indianmeal.util.Functions


class MealDetails : BaseFragment<FragmentDetailmealBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailmealBinding
        get() = FragmentDetailmealBinding::inflate

    override fun setup() {
        (this@MealDetails.context as HomeActivity).checkFragment(this)
        val id=this.arguments?.getInt(Constants.meal_id)
        val p=Functions.getPosition(id!!)
        val current=DataManeger.listOfMeals[p]
        binding.apply {
        nameMeal.text=current.mealName
        costMeals.text=current.price
        cuisine.text=current.cuisine
        timeMeals.text=current.totalTime
        components.text=current.ingredients
        Glide.with(this@MealDetails).load(current.imageUrl).into(imageViewdetail)
        preparation.text=current.preparation

            if (current.lovely)
                love.setImageResource(R.drawable.love)
            else
                love.setImageResource(R.drawable.baseline_love)

        }
        binding.moreButton.setOnClickListener {
            val bundle=Bundle()
            bundle.putString(Constants.url_key,current.webUrl)
            val fragment=WebView()
            fragment.arguments=bundle
            Functions.setFragment(this,fragment)

        }
        binding.backIcon.setOnClickListener {
            (this.context as HomeActivity).onBackPressed()
        }

        binding.love.setOnClickListener {
            current.lovely=!current.lovely
            binding.apply {
                if (current.lovely){
                    love.setImageResource(R.drawable.love)
                    DataManeger.addLovelyMeal(current)
                    DataManeger.saveLovelyList(DataManeger.listOfLovelyMeals,
                        this@MealDetails.context as HomeActivity
                    )
                }
                else{
                    love.setImageResource(R.drawable.baseline_love)
                    DataManeger.removeLovelyMeal(p)
                    DataManeger.saveLovelyList(DataManeger.listOfLovelyMeals,
                        this@MealDetails.context as HomeActivity
                    )
                }
            }
        }

  }
}