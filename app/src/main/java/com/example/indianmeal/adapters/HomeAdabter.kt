package com.example.indianmeal.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.indianmeal.R
import com.example.indianmeal.data.HomeItem
import com.example.indianmeal.databinding.ItemFlipBinding
import com.example.indianmeal.databinding.ItemParentHorizontalBinding
import com.example.indianmeal.util.ItemType

class HomeAdabter(val list:List<HomeItem>) :RecyclerView.Adapter<HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val parentItemView =LayoutInflater.from(parent.context).inflate(R.layout.item_parent_horizontal,null)
    return HomeViewHolder(parentItemView)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val current=list[position]
        when (current.itemType) {
            ItemType.ITEM_FOOD_FLIPER -> {
                holder.binding.parentRecycler.adapter=AdapterFliper(current.listItem)
            }
            ItemType.ITEM_FOOD-> {
                holder.binding.parentRecycler.adapter=FoodAdapter(current.listItem)
            }
            ItemType.ITEM_FOOD-> {holder.binding.parentRecycler.adapter=FoodAdapter(current.listItem)}
        }
    }


    override fun getItemCount(): Int {
        return list.size
    }

}

class HomeViewHolder(item: View):RecyclerView.ViewHolder(item){
    val binding=ItemParentHorizontalBinding.bind(item)
}


