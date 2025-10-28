package com.proyecto.vetes.repository

import com.proyecto.vetes.data.Sale
import com.proyecto.vetes.data.dao.SaleDao
import kotlinx.coroutines.flow.Flow

class SaleRepository(private val saleDao: SaleDao) {
    val allSales: Flow<List<Sale>> = saleDao.getAllSales()
    
    suspend fun insertSale(sale: Sale): Long = saleDao.insertSale(sale)
    
    suspend fun deleteSale(sale: Sale) = saleDao.deleteSale(sale)
    
    suspend fun deleteAllSales() = saleDao.deleteAllSales()
    
    fun getSalesByDateRange(startDate: Long, endDate: Long): Flow<List<Sale>> =
        saleDao.getSalesByDateRange(startDate, endDate)
    
    suspend fun getTotalSalesByDateRange(startDate: Long, endDate: Long): Double =
        saleDao.getTotalSalesByDateRange(startDate, endDate) ?: 0.0
}

