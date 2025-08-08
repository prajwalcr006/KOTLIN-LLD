package com.prajwalcr.kotlin_lld_prajwal.vending_machine.inventory

import com.prajwalcr.kotlin_lld_prajwal.vending_machine.exceptions.InvalidSlotException

class Inventory {
    private val itemShelf: MutableList<ItemSpace> = MutableList(10) { ItemSpace() }

    fun fillDefaultInventory() {
        for (i in 0 ..9) {
            if (i in 0..2) {
                itemShelf[i].addItem(Item(ItemType.COKE, 60.0))
            } else if (i in 3..5) {
                itemShelf[i].addItem(Item(ItemType.CHIPS, 40.0))
            } else {
                itemShelf[i].addItem(Item(ItemType.BISCUITS, 100.0))
            }
        }
    }

    fun getItem(slotNumber: Int, userAmount: Double): Item {
        if (slotNumber in 0..9) {
            return itemShelf[slotNumber].removeItem(userAmount)
        }
        throw InvalidSlotException()
    }

    fun addItem(slotNumber: Int, item: Item): Boolean {
        var success = false
        if ((item.type == ItemType.COKE) && (slotNumber in 0..2)) {
            success = itemShelf[slotNumber].addItem(item)
        } else if ((item.type == ItemType.CHIPS) && (slotNumber in 3..5)) {
            success = itemShelf[slotNumber].addItem(item)
        } else if ((item.type == ItemType.BISCUITS) && (slotNumber in 6..9)) {
            success = itemShelf[slotNumber].addItem(item)
        }

        return success
    }
}