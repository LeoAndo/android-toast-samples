package com.example.toastcomposesample.ui.androidview.extention

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.widget.Toast
import com.example.toastcomposesample.R
import com.example.toastcomposesample.ui.androidview.MyToastCallBackHandler

@SuppressLint("InflateParams")
fun Activity.showCustomToast() {
    Handler(Looper.myLooper()!!).postDelayed({
        Toast(this).apply {
            duration = Toast.LENGTH_SHORT
            view = layoutInflater.inflate(R.layout.custom_toast_layout, null)
            setGravity(Gravity.TOP, -140, 180)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                addCallback(MyToastCallBackHandler)
            }
        }.show()
    }, 2000L)
}