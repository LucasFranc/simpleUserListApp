package com.example.simpleuserlistapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.simpleuserlistapplication.presentation.SimpleNameListScreen

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController, startDestination = Routes.SimpleNameList.route) {
        composable(Routes.SimpleNameList.route) {
            SimpleNameListScreen()
        }
    }
}