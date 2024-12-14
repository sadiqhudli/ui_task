package com.developerssays.uitask.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.developerssays.uitask.compounds.CheckListScreen
import com.developerssays.uitask.compounds.HomeScreen
import com.developerssays.uitask.viewModel.HomeViewModel


@Composable
fun AppNavigation(
    innerPadding: PaddingValues,
) {
    val viewModel: HomeViewModel = viewModel()
    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = "Home"
    ) {
        composable(route = "home") {

            HomeScreen(innerPadding = innerPadding, navController, viewModel)
        }

        composable(
            "CheckListScreen"
        ) {
            CheckListScreen(
                navController, viewModel
            )
        }

    }
}