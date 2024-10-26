package com.example.themagicalignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.themagicalignment.ui.theme.TheMagicAlignmentTheme
import com.example.themagicalignment.view.LoginPage
import com.example.themagicalignment.viewmodel.HomeViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val homeViewModel = ViewModelProvider(this)[HomeViewModel::class]
        setContent {
           TheMagicAlignmentTheme {
               Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   LoginPage(modifier = Modifier.padding(innerPadding), homeViewModel, true)

               }
           }
        }
    }
}




