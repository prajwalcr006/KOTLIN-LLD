package com.prajwalcr.kotlin_lld_prajwal.facade.internal

import com.prajwalcr.kotlin_lld_prajwal.facade.model.Product
import com.prajwalcr.kotlin_lld_prajwal.facade.model.productMap
import java.util.LinkedList
import java.util.Queue
import java.util.UUID
import java.util.concurrent.LinkedBlockingDeque
import java.util.concurrent.LinkedBlockingQueue
import kotlin.random.Random

class ProductDAO {
    private fun getProductPrice(productName: String, price: Double): Double {
        return productMap[productName]?.peek()?.price ?: price
    }

    fun addProduct(productName: String, price: Double) {
        productMap.computeIfAbsent(productName) { LinkedBlockingQueue() }.add(
            Product(
                id = UUID.randomUUID(),
                name = productName,
                price = getProductPrice(productName, price)
            )
        )
    }
}