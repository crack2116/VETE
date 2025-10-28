package com.proyecto.vetes.data.dao

import androidx.room.*
import com.proyecto.vetes.data.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Query("SELECT * FROM products ORDER BY name ASC")
    fun getAllProducts(): Flow<List<Product>>
    
    @Query("SELECT * FROM products WHERE id = :id")
    suspend fun getProductById(id: Long): Product?
    
    @Query("SELECT * FROM products WHERE stock <= minStock")
    fun getLowStockProducts(): Flow<List<Product>>
    
    @Query("SELECT * FROM products WHERE name LIKE '%' || :search || '%' OR description LIKE '%' || :search || '%'")
    fun searchProducts(search: String): Flow<List<Product>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: Product): Long
    
    @Update
    suspend fun updateProduct(product: Product)
    
    @Delete
    suspend fun deleteProduct(product: Product)
}

