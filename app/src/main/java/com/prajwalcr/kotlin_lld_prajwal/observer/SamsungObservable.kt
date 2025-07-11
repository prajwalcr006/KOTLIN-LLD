package com.prajwalcr.kotlin_lld_prajwal.observer

class SamsungObservable(
    private var samsungQuantity: Int = 0
): Observable() {
    companion object {
        const val AVAILABLE_MESSAGE = "Samsung Are Added To Inventory"
        const val OUT_OF_STOCK_MESSAGE = "Samsung Out Of Stocks"
    }

    fun getSamsungQuantity() = samsungQuantity

    fun addSamsung(quantity: Int) {
        samsungQuantity += quantity
        if (samsungQuantity == quantity) {
            notifyObservers(message = AVAILABLE_MESSAGE)
        }
    }

    fun purchaseSamsung(): Boolean {
        if (samsungQuantity > 0) {
            samsungQuantity--
            return true
        }
        notifyObservers(message = OUT_OF_STOCK_MESSAGE)
        return false
    }
}