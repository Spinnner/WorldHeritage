package com.spinner.worldheritage.presentation.screen

sealed class Screen(val route: String) {
    data object HeritageSitesScreen: Screen("heritage_sites_screen")
}