package com.example.indianmeal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.indianmeal.databinding.ItemActivitymainSearchBinding


abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    abstract val inflate: (LayoutInflater, ViewGroup?, Boolean) -> VB
    private lateinit var _lateinitBinding: VB
    protected lateinit var binding:VB
    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _lateinitBinding = inflate(inflater, container, false)
        binding= requireNotNull(_lateinitBinding)
        setup()
        return _lateinitBinding!!.root

    }
    abstract fun setup()

}