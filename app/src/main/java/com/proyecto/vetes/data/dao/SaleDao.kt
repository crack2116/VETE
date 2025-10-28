package com.proyecto.vetes.data.dao

import androidx.room.*
import com.proyecto.vetes.data.Sale
import kotlinx.coroutines.flow.Flow

@Dao
interface SaleDao {
    @Query("SELECT * FROM sales ORDER BY date DESC")
    fun getAllSales(): Flow<List<Sale>>
    
    @Query("SELECT * FROM sales WHERE date BETWEEN :startDate AND :endDate ORDER BY date DESC")
    fun getSalesByDateRange(startDate: Long, endDate: Long): Flow<List<Sale>>
    
    @Query("SELECT SUM(totalPrice) as total FROM sales WHERE date BETWEEN :startDate AND :endDate")
    suspend fun getTotalSalesByDateRange(startDate: Long, endDate: Long): Double?
    
    @Insert
    suspend fun insertSale(sale: Sale): Long
    
    @Delete
    suspend fun deleteSale(sale: Sale)
    
    @Query("DELETE FROM sales")
    suspend fun deleteAllSales()
}

