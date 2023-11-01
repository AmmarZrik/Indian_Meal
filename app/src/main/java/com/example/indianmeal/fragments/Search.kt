package com.example.indianmeal.fragments


import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.awesomedialog.AwesomeDialog
import com.example.awesomedialog.background
import com.example.awesomedialog.body
import com.example.awesomedialog.icon
import com.example.awesomedialog.onNegative
import com.example.awesomedialog.onPositive
import com.example.awesomedialog.title
import com.example.indianmeal.R
import com.example.indianmeal.adapters.MealAdapter
import com.example.indianmeal.data.DataManeger
import com.example.indianmeal.data.Meals
import com.example.indianmeal.databinding.FragmentSearchBinding
import com.example.indianmeal.util.OnClickItem
import java.util.Locale


class Search : BaseFragment<FragmentSearchBinding>(), OnClickItem {
    private lateinit var rv_meal: RecyclerView
    private lateinit var adapter: MealAdapter
    private var mlist = DataManeger.listOfMeals

    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate

    override fun setup() {
        Filter_for_theName()

        filter()
    }

    private fun Filter_for_theCuisine() {
        rv_meal = binding.recyclerviewMeal
        val  searchview = binding.SearchView
        rv_meal.setHasFixedSize(true)
        rv_meal.layoutManager = GridLayoutManager(context,1)
        adapter = MealAdapter(mlist,this)
        rv_meal.adapter = adapter
        searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                filterList1(newText)
                return true

            }
        })
    }

    private fun filter() {
        val filter=binding.filter
        filter.setOnClickListener { builder() }
    }

    private fun builder() {
        AwesomeDialog.build(context as Activity)
            .title("Filter", titleColor = ContextCompat.getColor(context as Activity, R.color.black))
            .body("")
            .icon(R.drawable.filter,true)
            .background(R.drawable.backgrounddialog)
            .onPositive(
                "NameMeals",
                R.drawable.backgroundbuttomdialog,
                ContextCompat.getColor(context as Activity, R.color.white))
            {
                Filter_for_theName()
            }
            .onNegative("Cuisine",
                R.drawable.backgroundbuttomdialog,
                ContextCompat.getColor(context as Activity, R.color.white))
            {
                Filter_for_theCuisine()
            }


    }

    private fun Filter_for_theName() {
        rv_meal = binding.recyclerviewMeal
        val  searchview = binding.SearchView
        rv_meal.setHasFixedSize(true)
        rv_meal.layoutManager = GridLayoutManager(context,1)
        adapter = MealAdapter(mlist,this)
        rv_meal.adapter = adapter
        searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                filterList(newText)
                return true

            }
        })
    }
    private fun filterList(newText: String) {
        if (newText!=null) {
            val filterLis=ArrayList<Meals>()
            for (it in mlist) {
                if (it.mealName.lowercase(Locale.ROOT).contains(newText)) {
                    filterLis.add(it)
                }
            }
            if (filterLis.isEmpty()) {
                Toast.makeText(context, "No Data", Toast.LENGTH_LONG).show()
            } else {
                adapter.applySearch(filterLis)

            }
        }
    }
    private fun filterList1(newText: String) {
        if (newText!=null) {
            val filterLis=ArrayList<Meals>()
            for (it in mlist) {
                if (it.cuisine.lowercase(Locale.ROOT).contains(newText)) {
                    filterLis.add(it)
                }
            }
            if (filterLis.isEmpty()) {
                Toast.makeText(context, "No Data", Toast.LENGTH_LONG).show()
            } else {
                adapter.applySearch(filterLis)

            }
        }
    }

    override fun onItemClick(
        position: Int,
        imageUrl: String,
        price: String,
        totalTime: String,
        cuisine: String,
        preparation: String,
        mealName: String
    ) {
        Toast.makeText(context,"onItemClick",Toast.LENGTH_SHORT).show()
//        val intent = Intent( context, DetailMeal::class.java)
//        intent.putExtra("imageUrl1",imageUrl)
//        intent.putExtra("price1",price)
//        intent.putExtra("totalTime1",totalTime)
//        intent.putExtra("cuisine1",cuisine)
//        intent.putExtra("preparation1",preparation)
//        intent.putExtra("mealName1",mealName)
//        startActivity(intent)
    }

    override fun onloveItemClick(
        position: Int,
        imageUrl: String,
        price: String,
        totalTime: String,
        cuisine: String,
        preparation: String,
        mealName: String
    ) {
        Toast.makeText(context,"onloveItemClick",Toast.LENGTH_SHORT).show()
        val intent = Intent( context, LovelyMeals::class.java)
        intent.putExtra("imageUrl",imageUrl)
        intent.putExtra("price",price)
        intent.putExtra("totalTime",totalTime)
        intent.putExtra("cuisine",cuisine)
        intent.putExtra("preparation",preparation)
        intent.putExtra("mealName",mealName)
        startActivity(intent)
    }


}