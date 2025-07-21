package com.prajwalcr.kotlin_lld_prajwal.facade.model

import java.util.Queue
import java.util.UUID

data class Product(
    val id: UUID,
    val name: String,
    val price: Double
)

val productMap: MutableMap<String, Queue<Product>> = mutableMapOf()