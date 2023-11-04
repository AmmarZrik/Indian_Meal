package com.example.indianmeal.fragments


import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.indianmeal.databinding.FragmentSearchBinding


class Search : BaseFragment<FragmentSearchBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate

    override fun setup() {

    }
}