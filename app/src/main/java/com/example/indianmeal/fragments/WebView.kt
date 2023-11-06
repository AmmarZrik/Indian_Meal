package com.example.indianmeal.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.indianmeal.HomeActivity
import com.example.indianmeal.data.Constants
import com.example.indianmeal.databinding.FragmentWebviewBinding

class WebView : BaseFragment<FragmentWebviewBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentWebviewBinding
        get() = FragmentWebviewBinding::inflate




    override fun setup() {
        val url=this.arguments?.getString(Constants.url_key,"")
        binding.webview.settings.javaScriptEnabled=true
        binding.webview.webViewClient=WebViewClient()
        binding.webview.loadUrl(url!!)
        val loadingDialog=ProgressDialog()
        binding.webview.webChromeClient=object :WebChromeClient(){
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                if (newProgress < 50) {
                    if (!loadingDialog.isAdded) {
                        loadingDialog.show((this@WebView.context as HomeActivity).supportFragmentManager, "Loading")
                    }
                } else {
                    if (loadingDialog.isAdded) {
                        loadingDialog.dismiss()
                    }
                }

            }
        }

    }


}