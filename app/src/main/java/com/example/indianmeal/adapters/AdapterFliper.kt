package com.example.indianmeal.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.indianmeal.R
import com.example.indianmeal.data.Meals
import com.example.indianmeal.databinding.ItemFlipBinding

class AdapterFliper(val list: List<Meals>):RecyclerView.Adapter<FliperViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FliperViewHolder {
        val flipView =LayoutInflater.from(parent.context).inflate(R.layout.item_flip,parent,false)
        return FliperViewHolder(flipView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: FliperViewHolder, position: Int) {
        val current=list[position]

        holder.binding.let {
            Glide.with(holder.itemView).asBitmap().apply(RequestOptions.overrideOf(300,300)).load(current.imageUrl).into(it.flipFoodImg)
            it.mealsName.text=current.mealName
            it.costMeals.text=current.price
            it.timeMeals.text=current.totalTime
        }
        holder.itemView.clearAnimation()
        holder.itemView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.context,android.R.anim.fade_in))
    }
}
class FliperViewHolder(item: View) :RecyclerView.ViewHolder(item){
    val binding=ItemFlipBinding.bind(item)
}