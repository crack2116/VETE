package com.proyecto.vetes.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.proyecto.vetes.data.dao.ProductDao
import com.proyecto.vetes.data.dao.SaleDao

@Database(
    entities = [Product::class, Sale::class],
    version = 1,
    exportSchema = false
)
abstract class VetDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun saleDao(): SaleDao
    
    companion object {
        @Volatile
        private var INSTANCE: VetDatabase? = null
        
        fun getInstance(context: Context): VetDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VetDatabase::class.java,
                    "vet_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

