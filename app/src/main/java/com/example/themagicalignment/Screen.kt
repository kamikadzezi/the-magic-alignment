package com.example.themagicalignment

sealed class Screen(val route: String) {
    data object HomeScreen : Screen(route = "home_screen")
    data object SecondScreen : Screen(route = "second_screen")

}