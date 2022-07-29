package com.example.entypoints.uitel

import android.app.Activity
import android.app.AlertDialog
import com.example.entypoints.R
import com.example.entypoints.ui.activity.MainActivity

class LoadingDialog(val mActivity: Activity) {
    private lateinit var isdialog:AlertDialog
    fun startLoading(){
        val infalter = mActivity.layoutInflater
        val dialogView = infalter.inflate(R.layout.progress_bar , null)
        val builder = AlertDialog.Builder(mActivity)
        builder.setView(dialogView)
        builder.setCancelable(false)
        isdialog = builder.create()
        isdialog.show()
    }

    fun isDismiss(){
        isdialog.dismiss()
    }
}