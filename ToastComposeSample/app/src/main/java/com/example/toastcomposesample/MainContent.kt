package com.example.toastcomposesample

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.example.toastcomposesample.ui.sample.ToastSampleScreen
import com.example.toastcomposesample.ui.theme.ToastComposeSampleTheme

@Composable
fun MainContent() {
    ToastComposeSampleTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            ToastSampleScreen()
        }
    }
}