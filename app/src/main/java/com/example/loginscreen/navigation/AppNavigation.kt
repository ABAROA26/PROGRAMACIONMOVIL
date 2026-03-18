package com.example.loginscreen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginscreen.Screens.LoginScreen
import com.example.loginscreen.Screens.RegisterScreen
import com.example.loginscreen.Screens.MainScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "main_screen"
    ) {
        composable("login_screen") {
            LoginScreen(navController)
        }

        composable("register_screen") {
            RegisterScreen(navController)
        }

        composable("main_screen") {
            MainScreen(navController)
        }
    }
}