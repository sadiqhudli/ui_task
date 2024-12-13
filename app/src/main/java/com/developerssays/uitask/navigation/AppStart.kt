package com.developerssays.uitask.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.developerssays.uitask.compounds.CheckListScreen
import com.developerssays.uitask.compounds.HomeScreen
import com.developerssays.uitask.viewModel.HomeViewModel


@Composable
fun AppNavigation(
    innerPadding: PaddingValues,
) {
    val navController = rememberNavController()
    val viewModel: HomeViewModel = viewModel()
    NavHost(
        navController = navController, startDestination = "Home"
    ) {
        composable(route = "home") {
            HomeScreen(innerPadding = innerPadding, navController)
        }


        composable(
            route = "checkList/{cartItemsJson}",
            arguments = listOf(navArgument("cartItemsJson") { type = NavType.StringType })
        ) { backStackEntry ->
            val cartItemsJson = backStackEntry.arguments?.getString("cartItemsJson")
            CheckListScreen(navController, cartItemsJson)
        }

        }
}