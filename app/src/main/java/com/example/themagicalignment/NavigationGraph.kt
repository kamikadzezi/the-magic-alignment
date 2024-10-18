package com.example.themagicalignment

import android.util.EventLogTags.Description
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cardSelection.ButtonImage
import cardSelection.CardSelectionScreen
import selectionOfLayout.SelectionOfLayout

@Composable
fun NavigationGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(
            route = Screen.HomeScreen.route
        ) {
            SelectionOfLayout(
                onChooseCardScreen = {navController.navigate(Screen.SecondScreen.route)}
            )
        }
        composable(
            route = Screen.SecondScreen.route
        ) {
            CardSelectionScreen(backClick = { navController.navigate(Screen.HomeScreen.route) })
        }
    }
}

