package com.proyecto.vetes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.proyecto.vetes.repository.ProductRepository
import com.proyecto.vetes.ui.home.HomeScreen
import com.proyecto.vetes.ui.inventory.AddEditProductScreen
import com.proyecto.vetes.ui.inventory.InventoryScreen
import com.proyecto.vetes.ui.sales.NewSaleScreen
import com.proyecto.vetes.ui.sales.SalesScreen
import com.proyecto.vetes.ui.theme.VETESTheme
import com.proyecto.vetes.util.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val application = application as VetApplication
        val productRepository = application.productRepository
        val saleRepository = application.saleRepository
        
        enableEdgeToEdge()
        setContent {
            VETESTheme {
                VetESApp(
                    productRepository = productRepository,
                    saleRepository = saleRepository
                )
            }
        }
    }
}

@Composable
fun VetESApp(
    productRepository: ProductRepository,
    saleRepository: SaleRepository,
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val productViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = ProductViewModelFactory(productRepository)
    )
    val saleViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = SaleViewModelFactory(saleRepository)
    )
    
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToInventory = {
                    navController.navigate(Screen.Inventory.route)
                },
                onNavigateToSales = {
                    navController.navigate(Screen.Sales.route)
                }
            )
        }
        
        composable(Screen.Inventory.route) {
            InventoryScreen(
                viewModel = productViewModel,
                onNavigateToAddProduct = {
                    navController.navigate(Screen.AddProduct.route)
                },
                onNavigateToEditProduct = { productId ->
                    productViewModel.getProductById(productId)
                    navController.navigate(Screen.EditProduct.createRoute(productId))
                },
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable(Screen.AddProduct.route) {
            AddEditProductScreen(
                viewModel = productViewModel,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable(
            route = "edit_product/{productId}",
            arguments = listOf(
                androidx.navigation.NavArgument("productId") {
                    type = androidx.navigation.NavType.LongType
                }
            )
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getLong("productId")
            AddEditProductScreen(
                viewModel = productViewModel,
                productId = productId,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable(Screen.Sales.route) {
            SalesScreen(
                viewModel = saleViewModel,
                onNavigateToNewSale = {
                    navController.navigate(Screen.NewSale.route)
                },
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable(Screen.NewSale.route) {
            NewSaleScreen(
                productViewModel = productViewModel,
                saleViewModel = saleViewModel,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}