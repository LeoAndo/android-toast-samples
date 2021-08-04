package com.template.toastjavasample;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonShowToastMessage = findViewById(R.id.buttonShowToastMessage);
        buttonShowToastMessage.setOnClickListener((v) -> {
            final Toast toast = Toast.makeText(this, "show toast message!!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, -140, 180); // Android 11ではこの設定は呼び出しても無効.
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                toast.addCallback(new MyToastCallBackHandler());
            }
            toast.show();
        });

        Button buttonShowCustomToast = findViewById(R.id.buttonShowCustomToast);
        buttonShowCustomToast.setOnClickListener((v) -> showCustomToast());

        Button buttonShowSnackBar = findViewById(R.id.buttonShowSnackBar);
        buttonShowSnackBar.setOnClickListener((v) -> Snackbar.make(v, "Snackbar message!!", Snackbar.LENGTH_SHORT).show());
    }

    @SuppressLint("InflateParams")
    private void showCustomToast() {
        new Handler(Looper.myLooper()).postDelayed(() -> {
            final Toast toast = new Toast(this);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(getLayoutInflater().inflate(R.layout.custom_toast_layout, null));
            toast.setGravity(Gravity.TOP, -140, 180);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                toast.addCallback(new MyToastCallBackHandler());
            }
            toast.show();
        }, 2000L);
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    private static class MyToastCallBackHandler extends Toast.Callback {
        @Override
        public void onToastHidden() {
            super.onToastHidden();
            Log.w("MyToastCallBackHandler", "onToastHidden");
        }

        @Override
        public void onToastShown() {
            super.onToastShown();
            Log.w("MyToastCallBackHandler", "onToastShown");
        }
    }
}