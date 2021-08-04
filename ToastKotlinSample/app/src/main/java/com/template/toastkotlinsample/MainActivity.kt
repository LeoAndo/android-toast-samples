package com.template.toastkotlinsample

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonShowToastMessage).setOnClickListener {
            Toast.makeText(this@MainActivity, "show toast message!!", Toast.LENGTH_SHORT).apply {
                setGravity(Gravity.TOP, -140, 180) // Android 11ではこの設定は呼び出しても無効.
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    addCallback(MyToastCallBackHandler)
                }
            }.show()
        }
        findViewById<Button>(R.id.buttonShowCustomToast).setOnClickListener {
            showCustomToast()
        }
        findViewById<Button>(R.id.buttonShowSnackBar).setOnClickListener {
            Snackbar.make(it, "Snackbar message!!", Snackbar.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("InflateParams")
    private fun showCustomToast() {
        Handler(Looper.myLooper()!!).postDelayed({
            Toast(this@MainActivity).apply {
                duration = Toast.LENGTH_SHORT
                view = layoutInflater.inflate(R.layout.custom_toast_layout, null)
                setGravity(Gravity.TOP, -140, 180)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    addCallback(MyToastCallBackHandler)
                }
            }.show()
        }, 2000L)
    }
}

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
