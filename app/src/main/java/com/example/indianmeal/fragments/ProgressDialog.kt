package com.example.indianmeal.fragments

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.indianmeal.R


class ProgressDialog:DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog= super.onCreateDialog(savedInstanceState)
        dialog.setContentView(R.layout.progress_dialog)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return dialog
    }
}