package com.prajwalcr.kotlin_lld_prajwal.vending_machine

fun main() {
    val vendingMachine = VendingMachine()

    try {
        vendingMachine.getMachineState().setDefaultInventory(vendingMachine)
        vendingMachine.getMachineState().clickOnPurchaseProductsButton(vendingMachine)
        vendingMachine.getMachineState().insertCash(vendingMachine, 200.0)
        vendingMachine.getMachineState().selectProduct(vendingMachine, 3)
        val item = vendingMachine.getMachineState().dispenseProduct(vendingMachine)
        println("Item: $item dispensed")
        val change = vendingMachine.getMachineState().returnChange(vendingMachine)
        println("change: $change returned")
    } catch (ex: Exception) {
        println("Exception in Main!! EX: $ex")
    }
}