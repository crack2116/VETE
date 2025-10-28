package com.proyecto.vetes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proyecto.vetes.data.Product
import com.proyecto.vetes.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductViewModel(private val repository: ProductRepository) : ViewModel() {
    val products = repository.allProducts
    
    private val _lowStockProducts = MutableStateFlow<List<Product>>(emptyList())
    val lowStockProducts: StateFlow<List<Product>> = _lowStockProducts.asStateFlow()
    
    private val _searchResults = MutableStateFlow<List<Product>>(emptyList())
    val searchResults: StateFlow<List<Product>> = _searchResults.asStateFlow()
    
    private val _selectedProduct = MutableStateFlow<Product?>(null)
    val selectedProduct: StateFlow<Product?> = _selectedProduct.asStateFlow()
    
    init {
        viewModelScope.launch {
            repository.getLowStockProducts().collect {
                _lowStockProducts.value = it
            }
        }
    }
    
    fun insertProduct(product: Product) = viewModelScope.launch {
        repository.insertProduct(product)
    }
    
    fun updateProduct(product: Product) = viewModelScope.launch {
        repository.updateProduct(product)
    }
    
    fun deleteProduct(product: Product) = viewModelScope.launch {
        repository.deleteProduct(product)
    }
    
    fun searchProducts(query: String) {
        viewModelScope.launch {
            repository.searchProducts(query).collect {
                _searchResults.value = it
            }
        }
    }
    
    fun getProductById(id: Long) = viewModelScope.launch {
        _selectedProduct.value = repository.getProductById(id)
    }
    
    fun clearSearch() {
        _searchResults.value = emptyList()
    }
}

