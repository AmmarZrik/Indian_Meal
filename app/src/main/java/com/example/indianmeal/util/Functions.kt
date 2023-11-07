package com.example.indianmeal.util

import android.os.Bundle
import android.transition.Fade
import android.transition.Slide
import android.view.Gravity
import androidx.fragment.app.Fragment
import com.example.indianmeal.HomeActivity
import com.example.indianmeal.R
import com.example.indianmeal.adapters.BaseViewHolder
import com.example.indianmeal.data.Constants
import com.example.indianmeal.data.DataManeger
import com.example.indianmeal.data.Meals
import com.example.indianmeal.fragments.MealDetails

object Functions {
    fun getPosition(id:Int):Int{
        var index=0
        var position=0

        for(i in DataManeger.listOfMeals){
            index++
            if(i.id==id)
                position=--index

        }
        return position

    }
    fun transactionFragment(holder : BaseViewHolder, current: Meals){
        val exitTransition = Fade()
        exitTransition.duration = 300

        val bundle= Bundle()
        bundle.putInt(Constants.meal_id,current.id)
        val fragment= MealDetails()
        fragment.exitTransition = exitTransition
        fragment.arguments=bundle
        val transaction=(holder.itemView.context as HomeActivity).supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    fun setFragment(currentFragment: Fragment,newFragment: Fragment) {

        val transaction = (currentFragment.context as HomeActivity).supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment, newFragment)
        transaction.addToBackStack(null)
        transaction.commit()



    }

}