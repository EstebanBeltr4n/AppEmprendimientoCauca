package com.example.appemprendimientocauca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import com.example.appemprendimientocauca.ui.theme.AppEmprendimientoCaucaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            AppEmprendimientoCaucaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                ) {
                    //("Android")
                }
            }
        }
    }
}

