package com.prajwalcr.kotlin_lld_prajwal.vending_machine.state

import com.prajwalcr.kotlin_lld_prajwal.vending_machine.VendingMachine
import com.prajwalcr.kotlin_lld_prajwal.vending_machine.exceptions.InvalidStateException
import com.prajwalcr.kotlin_lld_prajwal.vending_machine.inventory.Item

class HasMoney: State {
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
        machine.addUserAmount(cash)
        machine.setMachineState(ProductSelection())
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
        machine.setMachineState(Idle())
        return machine.getUserAmount()
    }
}