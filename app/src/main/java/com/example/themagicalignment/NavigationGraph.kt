package com.example.themagicalignment

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
                onChooseCardScreen = {} // TODO #6 - Добавить переход на экран выбора колоды
            )
        }
        composable(
            route = Screen.SecondScreen.route
        ) {
            CardSelectionScreen()

        }
    }
}

