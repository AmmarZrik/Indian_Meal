package com.example.indianmeal.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.indianmeal.R
import com.example.indianmeal.databinding.FragmentStartpageBinding

class StartPageFragment:BaseFragment<FragmentStartpageBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentStartpageBinding
        get() = TODO("Not yet implemented")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_startpage, container, false)
    }

    override fun setup() {
        binding.apply {
            buttonGetstarted.setOnClickListener {
                val i= Intent(context,SignUpFragment::class.java)
                startActivity(i)
            }

        }
    }
}