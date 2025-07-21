package com.prajwalcr.kotlin_lld_prajwal.facade.internal

import com.prajwalcr.kotlin_lld_prajwal.facade.model.Invoice

class Notification {
    fun notifyUser(invoice: Invoice) {
        println("Invoice sent to ${invoice.customerName}. Invoice = $invoice")
    }
}