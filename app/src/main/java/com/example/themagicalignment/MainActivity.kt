package com.example.themagicalignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.themagicalignment.ui.theme.TheMagicAlignmentTheme
import selectionOfLayout.SelectionOfLayout


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           TheMagicAlignmentTheme {
               val navigationController = rememberNavController()
               SelectionOfLayout(onChooseCardScreen = { navigationController.navigate(Screen.SecondScreen.route)})
               NavigationGraph(navController = navigationController)
           }
        }
    }
}




