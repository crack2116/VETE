package com.proyecto.vetes.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val description: String,
    val category: String,
    val price: Double,
    val stock: Int,
    val supplier: String? = null,
    val barcode: String? = null,
    val minStock: Int = 0
)

