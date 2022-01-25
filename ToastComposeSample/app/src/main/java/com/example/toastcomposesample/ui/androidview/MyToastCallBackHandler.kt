package com.example.toastcomposesample.ui.androidview

import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.R)
object MyToastCallBackHandler : Toast.Callback() {
    override fun onToastHidden() {
        super.onToastHidden()
        Log.w("MyToastCallBackHandler", "onToastHidden")
    }

    override fun onToastShown() {
        super.onToastShown()
        Log.w("MyToastCallBackHandler", "onToastShown")
    }
}
