package com.prajwalcr.kotlin_lld_prajwal.atm.exception

class NullValueException: Exception() {
    override val message: String?
        get() = "Null Value"
}