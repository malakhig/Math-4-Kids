package com.example.cs3180_sp2024_g04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cs3180_sp2024_g04.ui.theme.CS3180_SP2024_G04Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CS3180_SP2024_G04Theme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Route.loginScreen
                ){
                    composable(route = Route.loginScreen){
                        LoginFormPreview(
                            navigateToSelectScreen = { navController.navigate(Route.selectScreen) }
                        )
                    }

                    composable(route = Route.selectScreen){
                        SelectOptionPreview(
                            navigateToGameScreen = {navController.navigate(Route.gameScreen) },
                        )
                    }

                    composable(route = Route.gameScreen){
                        gamePreview(navigateBack = {navController.popBackStack(
                            route = Route.selectScreen,
                            inclusive = false
                        )}
                        )
                    }

                }

            }
        }
    }
}

object Route{
    const val  loginScreen = "loginScreen"
    const val  selectScreen = "selectScreen"
    const val  gameScreen = "gameScreen"

}