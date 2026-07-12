package com.ohatv.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.tv.material3.Surface
import com.ohatv.app.ui.theme.OhaTVTheme
import com.ohatv.app.ui.screens.MainScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OhaTVTheme {
                Surface {
                    MainScreen()
                }
            }
        }
    }
}
