package com.ragoju.latest.data.cartData

import androidx.lifecycle.LiveData
import com.ragoju.latest.data.ProductDao
import com.ragoju.latest.data.ProductEntity

class CartRepo(private val productDao: ProductDao) {

    val allCartProducts: LiveData<List<ProductEntity>> = productDao.getAll()

    suspend fun insert(product: ProductEntity) {
        productDao.insert(product)
    }
    suspend fun delete(product: ProductEntity) {
        productDao.delete(product)
    }
    suspend fun update(product: ProductEntity) {
        productDao.update(product)
    }
}