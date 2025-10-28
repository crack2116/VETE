package com.proyecto.vetes

import android.app.Application
import com.proyecto.vetes.data.VetDatabase
import com.proyecto.vetes.repository.ProductRepository
import com.proyecto.vetes.repository.SaleRepository

class VetApplication : Application() {
    val database by lazy { VetDatabase.getInstance(this) }
    val productRepository by lazy { ProductRepository(database.productDao()) }
    val saleRepository by lazy { SaleRepository(database.saleDao()) }
}

