package com.example.veteransos

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.veteransos.helpers.LocationHelper
import com.example.veteransos.helpers.NavigationHelper
import com.example.veteransos.services.EmergencyCaller
import com.example.veteransos.ui.theme.VeteranSOSTheme

class PanicActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VeteranSOSTheme {
                PanicUI()
            }
        }
    }

    @Composable
    fun PanicUI() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    val location = LocationHelper(this@PanicActivity).getLastKnownLocation()
                    NavigationHelper.goHome(this@PanicActivity, location)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .height(60.dp)
            ) {
                Text("Go Home", fontSize = 20.sp)
            }
            Button(
                onClick = {
                    EmergencyCaller.startCalling(this@PanicActivity)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .height(60.dp)
            ) {
                Text("Shelter In Place", fontSize = 20.sp)
            }
        }
    }
}