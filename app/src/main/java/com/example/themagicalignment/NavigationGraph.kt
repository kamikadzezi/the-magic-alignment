package com.example.themagicalignment

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import cardSelection.CardSelectionScreen
import selectionOfLayout.SelectionOfLayout

@Composable
fun NavigationGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route,
    ) {
        composable(
            route = Screen.HomeScreen.route
        ) {
            SelectionOfLayout(
                onChooseCardScreen = { navController.navigate(Screen.SecondScreen.route) },
                NavigateBack = { navController.navigateUp() }
            )
        }
        composable(
            route = Screen.SecondScreen.route
        ) {
            CardSelectionScreen(
                NavigateBack = { navController.navigateUp() },
                NavigationCardDescription = navController
            )
        }
        composable(
            route = Screen.DeckDescription.route + "/{textTitle}/{textBody}/{imageDeck}",
            arguments = listOf(
                navArgument(name = "textTitle") {
                    type = NavType.IntType
                },
                navArgument(name = "textBody") {
                    type = NavType.IntType
                },
                navArgument(name = "imageDeck") {
                    type = NavType.IntType
                },
            )
        ) { backstackEntry ->
            DeckDescription(
                backClick = { navController.navigateUp() },
                textTitle = backstackEntry.arguments?.getInt("textTitle")!!,
                textBody = backstackEntry.arguments?.getInt("textBody")!!,
                imageDeck = backstackEntry.arguments?.getInt("imageDeck")!!,

                )
        }


    }
}

