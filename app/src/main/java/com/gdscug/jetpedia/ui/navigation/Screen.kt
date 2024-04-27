package com.gdscug.jetpedia.ui.navigation

sealed class Screen(val route: String) {

    object Login : Screen("login")
    object Home : Screen("home")
    object Cart : Screen("cart")
    object Detail : Screen("detail/{id}") {
        fun createRoute(id: Int) = "detail/$id"
    }
}