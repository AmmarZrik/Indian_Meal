package com.example.indianmeal.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.indianmeal.R
import com.example.indianmeal.data.Meals
import com.example.indianmeal.databinding.ItemlovelymealsBinding

class LovelyMealsAdapter(val listoflovelymeals: List<Meals>): RecyclerView.Adapter<LovelyMealsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LovelyMealsViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.itemlovelymeals,null)
        return LovelyMealsViewHolder(View)
    }

    override fun getItemCount(): Int {
        return listoflovelymeals.size
    }

    override fun onBindViewHolder(holder: LovelyMealsViewHolder, position: Int) {
        val current=listoflovelymeals[position] as Meals
        holder.binding.let {
            Glide.with(holder.itemView).load(current.imageUrl).into(it.imageItemLovelymeals)
            it.nameItemLovelymeals.text=current.mealName
            it.costMealsItemLovelymeals.text=current.price
            it.timeMealsItemLovelymeals.text=current.totalTime
            it.cuisineItemLovelymeals.text=current.cuisine
        }
        
        }
    }
open class LovelyMealsViewHolder(val item: View) : RecyclerView.ViewHolder(item){
    val binding= ItemlovelymealsBinding.bind(item)
}