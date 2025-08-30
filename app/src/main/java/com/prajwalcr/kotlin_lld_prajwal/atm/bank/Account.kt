package com.prajwalcr.kotlin_lld_prajwal.atm.bank

import java.util.UUID

class Account {
    private val number: UUID = UUID.randomUUID()
    private var balance: Long = 0

    fun getBalance(): Long = balance

    fun setBalance(amount: Long) {
        balance += amount
    }
}