package com.proyecto.vetes.repository

import com.proyecto.vetes.data.Product
import com.proyecto.vetes.data.VetDatabase
import com.proyecto.vetes.data.dao.ProductDao
import kotlinx.coroutines.flow.Flow

class ProductRepository(private val productDao: ProductDao) {
    val allProducts: Flow<List<Product>> = productDao.getAllProducts()
    
    suspend fun insertProduct(product: Product): Long = productDao.insertProduct(product)
    
    suspend fun updateProduct(product: Product) = productDao.updateProduct(product)
    
    suspend fun deleteProduct(product: Product) = productDao.deleteProduct(product)
    
    suspend fun getProductById(id: Long): Product? = productDao.getProductById(id)
    
    fun searchProducts(search: String): Flow<List<Product>> = productDao.searchProducts(search)
    
    fun getLowStockProducts(): Flow<List<Product>> = productDao.getLowStockProducts()
}

