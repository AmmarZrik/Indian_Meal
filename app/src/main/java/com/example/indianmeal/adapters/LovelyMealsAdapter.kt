package com.example.indianmeal.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.indianmeal.R
import com.example.indianmeal.data.Constants
import com.example.indianmeal.data.DataManeger
import com.example.indianmeal.data.Meals
import com.example.indianmeal.databinding.ItemLovelymealsBinding
import com.example.indianmeal.handler
import com.example.indianmeal.util.Functions.transactionFragment

class LovelyMealsAdapter(val list: List<Meals>) : RecyclerView.Adapter<BaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val loelyView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_lovelymeals, parent, false)
        return LovelyViewHolder(loelyView)

    }


    override fun getItemCount(): Int {

        return list.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        var doubleClick = false
        val current = list[position]



                holder as LovelyViewHolder
                holder.binding.let {
                    Glide.with(holder.itemView).asBitmap()
                        .apply(RequestOptions.overrideOf(300, 300)).load(current.imageUrl)
                        .into(it.mealImage)
                    it.nameMeal.text = current.mealName
                    it.costMeals.text = current.price
                    it.timeMeals.text = current.totalTime
                    it.cuisine.text = current.cuisine
                    it.ingredients.text = current.ingredients
                    it.love.setOnClickListener {
                        if (!doubleClick)
                        Toast.makeText(holder.itemView.context,"Click it again",Toast.LENGTH_LONG).show()
                        else if (doubleClick) {
                            holder.binding.love.setImageResource(R.drawable.baseline_love)
                            DataManeger.removeLovelyMeal(list.size-holder.adapterPosition-1)
                            DataManeger.saveLovelyList(DataManeger.listOfLovelyMeals,holder.itemView.context)

                        }
                        doubleClick=true
                        handler.postDelayed({
                            doubleClick=false
                        }, Constants.handlerTime)
                        

                    }
                    holder.itemView.setOnClickListener {
                        transactionFragment(holder,current)
                    }

                    }
                }


    }


class LovelyViewHolder(item: View) : BaseViewHolder(item) {
    val binding = ItemLovelymealsBinding.bind(item)
}
