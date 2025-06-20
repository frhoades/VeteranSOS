package com.example.veteransos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.veteransos.ui.theme.VeteranSOSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VeteranSOSTheme {
                // Entry point could later be a Dashboard or Setup screen
            }
        }
    }
}