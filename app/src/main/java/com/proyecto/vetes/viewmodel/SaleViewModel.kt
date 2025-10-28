package com.proyecto.vetes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proyecto.vetes.data.Sale
import com.proyecto.vetes.repository.SaleRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SaleViewModel(private val repository: SaleRepository) : ViewModel() {
    val sales = repository.allSales
    
    private val _selectedSales = MutableStateFlow<List<Sale>>(emptyList())
    val selectedSales: StateFlow<List<Sale>> = _selectedSales.asStateFlow()
    
    private val _totalSales = MutableStateFlow(0.0)
    val totalSales: StateFlow<Double> = _totalSales.asStateFlow()
    
    private val _selectedDateRange = MutableStateFlow<Pair<Long, Long>?>(null)
    val selectedDateRange: StateFlow<Pair<Long, Long>?> = _selectedDateRange.asStateFlow()
    
    fun insertSale(sale: Sale) = viewModelScope.launch {
        repository.insertSale(sale)
    }
    
    fun deleteSale(sale: Sale) = viewModelScope.launch {
        repository.deleteSale(sale)
    }
    
    fun deleteAllSales() = viewModelScope.launch {
        repository.deleteAllSales()
    }
    
    fun getSalesByDateRange(startDate: Long, endDate: Long) = viewModelScope.launch {
        _selectedDateRange.value = Pair(startDate, endDate)
        repository.getSalesByDateRange(startDate, endDate).collect {
            _selectedSales.value = it
            calculateTotal(it)
        }
    }
    
    private fun calculateTotal(sales: List<Sale>) {
        _totalSales.value = sales.sumOf { it.totalPrice }
    }
    
    fun clearDateFilter() {
        _selectedDateRange.value = null
        _selectedSales.value = emptyList()
        _totalSales.value = 0.0
    }
}

