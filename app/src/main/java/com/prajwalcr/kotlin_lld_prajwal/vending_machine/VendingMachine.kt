package com.prajwalcr.kotlin_lld_prajwal.vending_machine

import com.prajwalcr.kotlin_lld_prajwal.vending_machine.inventory.Inventory
import com.prajwalcr.kotlin_lld_prajwal.vending_machine.inventory.Item
import com.prajwalcr.kotlin_lld_prajwal.vending_machine.state.Idle
import com.prajwalcr.kotlin_lld_prajwal.vending_machine.state.State

class VendingMachine {
    private var state: State = Idle()
    val inventory: Inventory = Inventory()

    private var totalAmountInMachine: Double = 0.0

    private var userAddedAmount: Double = 0.0

    private var itemInCart: Item? = null

    fun getMachineState() = state

    fun getItemInCart() = itemInCart

    fun removeItemInCart(): Item? {
        val t = itemInCart
        if (itemInCart != null) {
            itemInCart = null
        }
        return t
    }

    fun setItemToCart(item: Item) {
        this.itemInCart = item
    }

    fun setMachineState(state: State) {
        this.state = state
    }

    fun makeUserAmountZero() {
        userAddedAmount = 0.0
    }

    fun addUserAmount(amount: Double) {
        userAddedAmount += amount
    }

    fun getUserAmount() = userAddedAmount

    fun addAmountToMachine(amount: Double) {
        totalAmountInMachine += amount
    }

}