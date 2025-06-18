package com.example.krypto.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.krypto.screen.MainScreen
import com.example.krypto.viewmodel.KryptoViewModel

@Composable
fun AppNavigation(navController: NavHostController, viewModel: KryptoViewModel) {
    NavHost(navController, startDestination = "splash") {
        composable("splash"){
            SplashScreen(navController = navController)
        }

        composable("main") {
            MainScreen(navController = navController, viewModel = viewModel)
        }

        composable("detail/{id}") { backStackEntry ->
            val coinId = backStackEntry.arguments?.getString("id")
            if (coinId != null) {
                DetailScreen(coinId = coinId, viewModel = viewModel)
            }
        }

}
}