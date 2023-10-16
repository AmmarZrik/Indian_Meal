package com.example.indianmeal.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.indianmeal.databinding.FragmentHomeBinding


class Home : BaseFragment<FragmentHomeBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate
}
