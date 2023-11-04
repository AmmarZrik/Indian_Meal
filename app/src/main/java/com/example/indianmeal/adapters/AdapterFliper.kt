package com.example.indianmeal.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.indianmeal.R
import com.example.indianmeal.data.DataManeger
import com.example.indianmeal.data.Meals
import com.example.indianmeal.databinding.ItemFlipBinding
import com.example.indianmeal.util.Functions

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
            if(current.lovely)
                it.love.setImageResource(R.drawable.love)
            else
                it.love.setImageResource(R.drawable.baseline_love)
            Glide.with(holder.itemView).asBitmap().apply(RequestOptions.overrideOf(300,300)).load(current.imageUrl).into(it.flipFoodImg)
            it.mealsName.text=current.mealName
            it.costMeals.text=current.price
            it.timeMeals.text=current.totalTime
            it.cuisine.text=current.cuisine
            loveIt(holder,current,list)

        }
        holder.itemView.let{
        it.clearAnimation()
        it.startAnimation(AnimationUtils.loadAnimation(holder.itemView.context,android.R.anim.fade_in))
            it.setOnClickListener {
                Functions.transactionFragment(holder, current)
            }
    }}
    fun  loveIt(holder:BaseViewHolder, current:Meals,list:List<Meals>){
        holder as FliperViewHolder

        holder.binding.let {
            if(current.lovely)
                it.love.setImageResource(R.drawable.love)
            else
                it.love.setImageResource(R.drawable.baseline_love)


            it.love.setOnClickListener {
                current.lovely = !current.lovely
                if(current.lovely)
                {
                    holder.binding.love.setImageResource(R.drawable.love)
                    DataManeger.addLovelyMeal(list[holder.adapterPosition])
                    DataManeger.saveLovelyList(DataManeger.listOfLovelyMeals,holder.itemView.context)

                }
                else{
                    holder.binding.love.setImageResource(R.drawable.baseline_love)
                    DataManeger.removeLovelyMeal(holder.adapterPosition)
                    DataManeger.saveLovelyList(DataManeger.listOfLovelyMeals,holder.itemView.context)

                }
            }}
    }
}
class FliperViewHolder(item: View) :BaseViewHolder(item){
    val binding=ItemFlipBinding.bind(item)
}