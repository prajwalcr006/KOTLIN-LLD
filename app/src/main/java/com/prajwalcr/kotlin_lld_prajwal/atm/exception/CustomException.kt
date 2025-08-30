package com.prajwalcr.kotlin_lld_prajwal.atm.exception

class CustomException(private val errorMessage: String): Exception() {
    override val message: String
        get() = errorMessage
}