package com.prajwalcr.kotlin_lld_prajwal.observer

interface Observer {
    fun update(observable: Observable, message: String?)
}