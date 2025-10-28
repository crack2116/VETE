package com.proyecto.vetes.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sales")
data class Sale(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val productId: Long,
    val productName: String,
    val quantity: Int,
    val unitPrice: Double,
    val totalPrice: Double,
    val date: Long = System.currentTimeMillis(),
    val clientName: String? = null,
    val paymentMethod: String = "Efectivo"
)

