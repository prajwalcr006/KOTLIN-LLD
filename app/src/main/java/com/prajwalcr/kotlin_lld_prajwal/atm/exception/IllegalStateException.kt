package com.prajwalcr.kotlin_lld_prajwal.atm.exception

class IllegalStateException: Exception() {
    override val message: String
        get() = "Invalid State"
}