package com.prajwalcr.kotlin_lld_prajwal.vending_machine.inventory

import com.prajwalcr.kotlin_lld_prajwal.vending_machine.exceptions.EmptySlotException
import com.prajwalcr.kotlin_lld_prajwal.vending_machine.exceptions.InsufficientFundsException

class ItemSpace {
    private var isEmpty: Boolean = true
    private var item: Item? = null

    fun addItem(item: Item):Boolean {
        return if (isEmpty) {
            isEmpty = false
            this.item = item
            true
        } else {
            false
        }
    }

    fun isItemAvailable(): Boolean = isEmpty

    fun removeItem(userAmount: Double): Item {
        return if (isEmpty) {
            throw EmptySlotException()
        } else if (item != null && item!!.price > userAmount) {
            throw InsufficientFundsException()
        } else {
            val t = this.item
            this.item = null
            isEmpty = true
            t!!
        }
    }
}