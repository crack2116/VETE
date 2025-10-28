package com.proyecto.vetes.util

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Inventory : Screen("inventory")
    object AddProduct : Screen("add_product")
    object EditProduct : Screen("edit_product/{productId}") {
        fun createRoute(productId: Long) = "edit_product/$productId"
    }
    object Sales : Screen("sales")
    object NewSale : Screen("new_sale")
}

