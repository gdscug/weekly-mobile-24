package com.gdscug.jetpedia.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gdscug.jetpedia.data.local.DummyProductsObject
import com.gdscug.jetpedia.ui.screen.cart.CartScreen
import com.gdscug.jetpedia.ui.screen.detail.DetailScreen
import com.gdscug.jetpedia.ui.screen.home.HomeScreen
import com.gdscug.jetpedia.ui.screen.login.LoginScreen

@Composable
fun JetPediaApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val products = DummyProductsObject.listOfProduct
        NavHost(navController = navController, startDestination = "Login") {
            composable("Login") {
                LoginScreen(onLogin = {
                    navController.navigate("Home")
                })
            }
            composable("Home") {
                HomeScreen(onProductClick = { id ->
                    navController.navigate("Detail/${id}")
                }, onCartClicked = {
                    navController.navigate("Cart")
                }, products = products)
            }
            composable(
                route = "Detail/{id}",
                arguments = listOf(navArgument("id") { type = NavType.IntType }),
            ) {
                val id = it.arguments?.getInt("id") ?: -1
                DetailScreen(
                    product = products.first { product -> product.id == id },
                    onAddToCartClick = {},
                    onBackPressed = {
                        navController.navigateUp()
                    }
                )
            }
            composable("Cart") {
                CartScreen(
                    cartProducts = listOf(),
                    onBackPressed = { navController.navigateUp() },
                    onCheckoutClick = { }
                )
            }
        }
    }
}