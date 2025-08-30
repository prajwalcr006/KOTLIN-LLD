package com.prajwalcr.kotlin_lld_prajwal.atm.bank

class Card(
    private val pin: Int,
    private val user: User
) {
    fun validateId(pin: Int) = this.pin == pin

    fun getUserDetails() = user
}