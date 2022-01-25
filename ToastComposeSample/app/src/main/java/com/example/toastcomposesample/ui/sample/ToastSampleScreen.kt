package com.example.toastcomposesample.ui.sample

import android.app.Activity
import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices.PIXEL_4
import androidx.compose.ui.tooling.preview.Devices.PIXEL_4_XL
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.toastcomposesample.ui.androidview.extention.showCustomToast
import com.example.toastcomposesample.ui.theme.ToastComposeSampleTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ToastSampleScreen(
    modifier: Modifier = Modifier,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    scope: CoroutineScope = rememberCoroutineScope(),
) {
    val act = LocalContext.current as Activity
    Scaffold(
        scaffoldState = scaffoldState,
    ) {
        Box(modifier = modifier) {
            ToastSampleContent(
                modifier = Modifier.fillMaxSize(),
                showToastMessage = {
                    Toast.makeText(
                        act,
                        "show Toast Message!!!",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                showCustomToastMessage = { act.showCustomToast() },
                showSnackBarMessage = {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("SnackBar Message!!!")
                    }
                }
            )
        }
    }
}

@Composable
fun ToastSampleContent(
    modifier: Modifier = Modifier,
    showToastMessage: () -> Unit,
    showCustomToastMessage: () -> Unit,
    showSnackBarMessage: () -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            showToastMessage()
        }) {
            Text(text = "showToastMessage")
        }
        Spacer(modifier = Modifier.size(24.dp))
        Button(onClick = { showCustomToastMessage() }) {
            Text(text = "showCustomToast")
        }
        Spacer(modifier = Modifier.size(24.dp))
        Button(onClick = { showSnackBarMessage() }) {
            Text(text = "showSnackBarMessage")
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, device = PIXEL_4_XL)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO, device = PIXEL_4)
@Composable
fun ToastSampleContentPreview() {
    ToastComposeSampleTheme {
        ToastSampleContent(
            modifier = Modifier.fillMaxSize(),
            showToastMessage = {},
            showCustomToastMessage = { },
            showSnackBarMessage = {
            }
        )
    }
}