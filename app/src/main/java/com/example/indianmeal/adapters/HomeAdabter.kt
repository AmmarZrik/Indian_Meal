package com.example.indianmeal.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.indianmeal.R
import com.example.indianmeal.data.Constants
import com.example.indianmeal.data.DataManeger
import com.example.indianmeal.data.HomeItem
import com.example.indianmeal.databinding.ItemIndianFoodBinding
import com.example.indianmeal.databinding.ItemParentHorizontalBinding
import com.example.indianmeal.util.ItemType

class HomeAdabter(val list: List<HomeItem>) : RecyclerView.Adapter<BaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val parentItemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_parent_horizontal, parent,false)
        val titleItemView=LayoutInflater.from(parent.context).inflate(R.layout.item_indian_food,parent,false)
        return if(viewType== VIEW_TITLE)
            TitleViewHolder(titleItemView)
        else
            HomeViewHolder(parentItemView)


    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {

        if(position>0) {
               val current=list[position-1]
                when(current.itemType){
                    ItemType.ITEM_FOOD->{
                        holder as HomeViewHolder
                        holder.binding.apply {
                        PouplarMealsText.text = current.title
                        parentRecycler.adapter = FoodAdapter(DataManeger.listOfMeals.shuffled())}
                    }
                    else ->{
                        holder as HomeViewHolder

                        val adapterFliper= AdapterFliper(DataManeger.listOfMeals.shuffled())

                        holder.binding.apply {
                        PouplarMealsText.visibility = View.GONE
                        parentRecycler.adapter =adapterFliper

                            holder.itemView.clearAnimation()
                           holder.itemView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.context,android.R.anim.fade_in))

                            parentRecycler.postDelayed(object : Runnable {
                                override fun run() {
                                    var p=(parentRecycler.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()+1
                                    if (p < adapterFliper.itemCount) {
                                        parentRecycler.smoothScrollToPosition(p)
                                        p=(parentRecycler.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()+1
                                        parentRecycler.postDelayed(this, Constants.handlerTime)
                                    }
                                    else {p=1}
                                }
                            }, Constants.handlerTime)
                        icon.visibility=View.GONE}
                    }

                }


}

     }



    override fun getItemCount(): Int {
        return list.size+1
    }

    override fun getItemViewType(position: Int): Int {
        return if(position==0)
            VIEW_TITLE
        else
            VIEW_PARENT_HORIZNTEL
    }
    companion object{
        val VIEW_TITLE=1
        val VIEW_PARENT_HORIZNTEL=2
    }
}


open class BaseViewHolder(item: View):RecyclerView.ViewHolder(item)
class HomeViewHolder(item: View) : BaseViewHolder(item) {
    val binding = ItemParentHorizontalBinding.bind(item)
}
class TitleViewHolder(item: View):BaseViewHolder(item){
    val binding=ItemIndianFoodBinding.bind(item)
}

