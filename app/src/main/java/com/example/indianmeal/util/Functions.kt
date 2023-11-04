package com.example.indianmeal.util

import android.os.Bundle
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

        val bundle= Bundle()
        bundle.putInt(Constants.meal_id,current.id)
        val fragment= MealDetails()
        fragment.arguments=bundle
        val fragmentManager=(holder.itemView.context as HomeActivity).supportFragmentManager
        val transaction=fragmentManager.beginTransaction()
        transaction.add(R.id.fragment,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}