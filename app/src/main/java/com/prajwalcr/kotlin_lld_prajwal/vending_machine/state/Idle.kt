package com.prajwalcr.kotlin_lld_prajwal.vending_machine.state

import com.prajwalcr.kotlin_lld_prajwal.vending_machine.VendingMachine
import com.prajwalcr.kotlin_lld_prajwal.vending_machine.exceptions.InvalidStateException
import com.prajwalcr.kotlin_lld_prajwal.vending_machine.inventory.Item

class Idle: State {
    override fun setDefaultInventory(machine: VendingMachine) {
        println("Filling Default inventory!!")
        machine.inventory.fillDefaultInventory()
    }

    override fun addInventory(machine: VendingMachine, slotNumber: Int, item: Item) {
        val success = machine.inventory.addItem(slotNumber, item)
        if (success) {
            println("Item added successfully!!")
        } else {
            println("Item not added!! Incompatible item type added to given slot number")
        }
    }

    override fun clickOnPurchaseProductsButton(machine: VendingMachine) {
        println("Purchase Process Started!!")
        machine.setMachineState(HasMoney())
    }

    override fun insertCash(machine: VendingMachine, cash: Double) {
        throw InvalidStateException()
    }

    override fun selectProduct(machine: VendingMachine, slotNumber: Int) {
        throw InvalidStateException()
    }

    override fun dispenseProduct(machine: VendingMachine): Item {
        throw InvalidStateException()
    }

    override fun returnChange(machine: VendingMachine): Double {
        throw InvalidStateException()
    }

    override fun cancelTransaction(machine: VendingMachine): Double {
        throw InvalidStateException()
    }

}