package com.prajwalcr.kotlin_lld_prajwal.facade.model

import java.util.UUID

data class Invoice(
    val invoiceId: UUID,
    val customerName: String,
    val totalAmount: Double,
    val productList: List<Product>
)
