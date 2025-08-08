package com.prajwalcr.kotlin_lld_prajwal.vending_machine.state

import com.prajwalcr.kotlin_lld_prajwal.vending_machine.VendingMachine
import com.prajwalcr.kotlin_lld_prajwal.vending_machine.exceptions.InvalidStateException
import com.prajwalcr.kotlin_lld_prajwal.vending_machine.exceptions.UnknownException
import com.prajwalcr.kotlin_lld_prajwal.vending_machine.inventory.Item

class ProductDispenser: State {
    override fun setDefaultInventory(machine: VendingMachine) {
        throw InvalidStateException()
    }

    override fun addInventory(machine: VendingMachine, slotNumber: Int, item: Item) {
        throw InvalidStateException()
    }

    override fun clickOnPurchaseProductsButton(machine: VendingMachine) {
        throw InvalidStateException()
    }

    override fun insertCash(machine: VendingMachine, cash: Double) {
        throw InvalidStateException()
    }

    override fun selectProduct(machine: VendingMachine, slotNumber: Int) {
        throw InvalidStateException()
    }

    override fun dispenseProduct(machine: VendingMachine): Item {
        return machine.getItemInCart() ?: throw UnknownException()
    }

    override fun returnChange(machine: VendingMachine): Double {
        machine.setMachineState(Idle())
        val item = machine.removeItemInCart()
        if (item != null) {
            machine.addAmountToMachine(item.price)
            val change = machine.getUserAmount() - item.price
            machine.makeUserAmountZero()
            return change
        } else {
            throw UnknownException()
        }
    }

    override fun cancelTransaction(machine: VendingMachine): Double {
        machine.setMachineState(Idle())
        return machine.getUserAmount()
    }
}