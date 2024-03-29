package com.damaris.vyza_segundo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.damaris.vyza_segundo.ui.screens.auth.LoginScreen
import com.damaris.vyza_segundo.ui.screens.auth.RegisterScreen
import com.damaris.vyza_segundo.ui.screens.home.HomeActivity
import com.damaris.vyza_segundo.ui.screens.viewmodel.AuthViewModel
import io.grpc.Context

@Composable
fun NavController(
    navController: NavHostController = rememberNavController()
) {
    val authViewModel = viewModel<AuthViewModel>()
    NavHost(
        navController = navController,
        startDestination = Screens.Register.name
    ) {
        composable(
            route = Screens.Register.name
        ) {
            RegisterScreen(
                loginClick = {
                    navController.navigate(Screens.Login.name) {
                        popUpTo(Screens.Register.name) {
                            inclusive = true
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        }

        composable(
            route = Screens.Login.name
        ) {
            LoginScreen(
                registerClick = {
                    navController.navigate(Screens.Register.name) {
                        popUpTo(Screens.Login.name) {
                            inclusive = true
                            saveState = true
                        }

                        launchSingleTop = true
                        restoreState = true
                    }
                },
                homeClick = {
                    navController.navigate(Screens.Home.name) {
                        popUpTo(Screens.Login.name) {
                            inclusive = true
                            saveState = true
                        }

                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }

        composable(
            route = Screens.Home.name
        ) {
            HomeActivity()
        }

    }
}