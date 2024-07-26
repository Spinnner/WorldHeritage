package com.spinner.worldheritage.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.spinner.worldheritage.presentation.screen.Screen
import com.spinner.worldheritage.presentation.screen.heritage_sites.HeritageSitesScreen
import com.spinner.worldheritage.presentation.ui.theme.WorldHeritageTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WorldHeritageTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.HeritageSitesScreen.route
                    ) {
                        composable(
                            route = Screen.HeritageSitesScreen.route
                        ) {
                            HeritageSitesScreen()
                        }
                    }
                }
            }
        }
    }
}