package com.example.indianmeal.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.indianmeal.R
import com.example.indianmeal.data.Meals
import com.example.indianmeal.databinding.ItemFlipBinding

class AdapterFliper(val list: List<Meals>):RecyclerView.Adapter<FliperViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FliperViewHolder {
        val flipView =LayoutInflater.from(parent.context).inflate(R.layout.item_flip,null)
        return FliperViewHolder(flipView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: FliperViewHolder, position: Int) {
        val current=list[position]
        holder.binding.let {
            Glide.with(holder.itemView).load(current.imageUrl).into(it.flipFoodImg)
            it.mealsName.text=current.mealName
            it.costMeals.text=current.price
            it.timeMeals.text=current.totalTime
        }
    }
}
open class FliperViewHolder(val item: View) :RecyclerView.ViewHolder(item){
    val binding=ItemFlipBinding.bind(item)
}