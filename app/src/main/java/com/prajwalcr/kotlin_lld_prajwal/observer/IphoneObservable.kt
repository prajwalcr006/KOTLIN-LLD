package com.prajwalcr.kotlin_lld_prajwal.observer

class IphoneObservable(
    private var iphoneQuantity: Int = 0
): Observable() {
    companion object {
        const val AVAILABLE_MESSAGE = "Iphone Are Added To Inventory"
        const val OUT_OF_STOCK_MESSAGE = "Iphone Out Of Stocks"
    }

    fun getIphoneQuantity() = iphoneQuantity

    fun addIphone(quantity: Int) {
        iphoneQuantity += quantity
        if (iphoneQuantity == quantity) {
            notifyObservers(message = AVAILABLE_MESSAGE)
        }
    }

    fun purchaseIphone(): Boolean {
        if (iphoneQuantity > 0) {
            iphoneQuantity--
            return true
        }
        notifyObservers(message = OUT_OF_STOCK_MESSAGE)
        return false
    }
}