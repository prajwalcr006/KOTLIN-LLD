package com.prajwalcr.kotlin_lld_prajwal.facade

import com.prajwalcr.kotlin_lld_prajwal.facade.internal.Notification
import com.prajwalcr.kotlin_lld_prajwal.facade.internal.Order
import com.prajwalcr.kotlin_lld_prajwal.facade.internal.Payment
import com.prajwalcr.kotlin_lld_prajwal.facade.internal.ProductDAO

class OrderFacade {
    private val productDAO = ProductDAO()
    private val order = Order()
    private val payment = Payment()
    private val notification = Notification()

    fun addProduct(productName: String, price: Double) {
        productDAO.addProduct(productName, price)
    }

    fun orderProduct(
        customerName: String,
        productName: String,
        quantity: Int,
        balance: Double
    ) {
        val productList = order.processOrder(productName, quantity)
        if (productList.isNotEmpty()) {
            val invoice = payment.makePayment(customerName,productList,balance)
            invoice?.let {
                notification.notifyUser(it)
            }
        }
    }
}