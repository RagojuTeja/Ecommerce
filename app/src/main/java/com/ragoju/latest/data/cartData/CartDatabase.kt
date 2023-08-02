package com.ragoju.latest.data.cartData

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ragoju.latest.data.ProductDao
import com.ragoju.latest.data.ProductEntity

@Database(entities = [ProductEntity::class], version = 1,exportSchema = false)
abstract class CartDatabase : RoomDatabase() {
    abstract fun productDAO(): ProductDao

    companion object {
//        private var instance: CartDatabase? = null
//        @Synchronized
//        fun getInstance(context: Context): CartDatabase? {
//            if (instance == null) {
//                instance = Room.databaseBuilder(
//                    context.applicationContext, CartDatabase::class.java, "ProductDatabase"
//                )
//                    .fallbackToDestructiveMigration()
//                    .build()
//            }
//            return instance
//        }
    }
}