package com.prajwalcr.kotlin_lld_prajwal.facade.internal

import com.prajwalcr.kotlin_lld_prajwal.facade.model.Invoice
import com.prajwalcr.kotlin_lld_prajwal.facade.model.Product
import java.util.UUID

class Payment {
    private fun getTotalAmount(productSelected: List<Product>): Double {
        var totalAmount = 0.0
        productSelected.forEach {
            totalAmount += it.price
        }

        return totalAmount
    }

    fun makePayment(
        customerName: String,
        productSelected: List<Product>,
        balance: Double
    ): Invoice? {
        val totalAmount = getTotalAmount(productSelected)
        return if (balance > totalAmount) {
            Invoice(
                invoiceId = UUID.randomUUID(),
                customerName = customerName,
                totalAmount = totalAmount,
                productList = productSelected
            )
        } else {
            println("Insufficient balance")
            null
        }
    }
}