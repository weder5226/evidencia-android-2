package com.evidencia.application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.evidencia.application.ui.*
import com.evidencia.application.ui.theme.ApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ApplicationTheme {
                AppNavigation()
            }
        }
    }
}
