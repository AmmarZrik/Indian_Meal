package com.example.indianmeal.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.indianmeal.R
import com.example.indianmeal.data.Meals
import com.example.indianmeal.databinding.ItemSearchBinding
import com.example.indianmeal.fragments.MealDetails
import com.example.indianmeal.util.Functions

class MealAdapter (var list: List<Meals>): RecyclerView.Adapter<MealViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val mealView = LayoutInflater.from(parent.context).inflate(R.layout.item_search ,null)
        return MealViewHolder(mealView)
    }
   fun applySearch(list: List<Meals>){
    this.list=list
   notifyDataSetChanged()
}
    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val current=list[position]
        holder.binding.let {
           Glide.with(holder.itemView).load(current.imageUrl).into(it.flipFoodImg)
        it.mealsName.text=current.mealName
          it.costMeals.text=current.price
            it.timeMeals.text=current.totalTime
            it.cuisine.text=current.cuisine
            }
        holder.itemView.setOnClickListener {
            Functions.transactionFragment(holder, current)
        }
        }




    override fun getItemCount(): Int {
        return list.size
    }

}
class MealViewHolder(val item: View) : BaseViewHolder(item){
    val binding= ItemSearchBinding.bind(item)



}