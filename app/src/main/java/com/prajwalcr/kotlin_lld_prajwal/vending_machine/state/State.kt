package com.prajwalcr.kotlin_lld_prajwal.vending_machine.state

import com.prajwalcr.kotlin_lld_prajwal.vending_machine.VendingMachine
import com.prajwalcr.kotlin_lld_prajwal.vending_machine.inventory.Item

interface State {
    fun setDefaultInventory(machine: VendingMachine)
    fun addInventory(machine: VendingMachine, slotNumber: Int, item: Item)
    fun clickOnPurchaseProductsButton(machine: VendingMachine)
    fun insertCash(machine: VendingMachine, cash: Double)
    fun selectProduct(machine: VendingMachine, slotNumber: Int)
    fun dispenseProduct(machine: VendingMachine): Item
    fun returnChange(machine: VendingMachine): Double
    fun cancelTransaction(machine: VendingMachine): Double
}