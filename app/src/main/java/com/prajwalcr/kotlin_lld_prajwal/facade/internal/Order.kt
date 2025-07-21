package com.prajwalcr.kotlin_lld_prajwal.facade.internal

import com.prajwalcr.kotlin_lld_prajwal.facade.model.Product
import com.prajwalcr.kotlin_lld_prajwal.facade.model.productMap

class Order() {
    fun processOrder(productName: String, quantity: Int): List<Product> {
        val listOfProducts = mutableListOf<Product>()
        productMap[productName]?.let { products ->
            if (products.size > quantity) {
                for (i in 1..quantity) {
                    listOfProducts.add(products.poll())
                }
            } else {
                println("Insufficient quantity available for $productName")
            }
        } ?: println("Product not found: $productName")

        return listOfProducts
    }
}