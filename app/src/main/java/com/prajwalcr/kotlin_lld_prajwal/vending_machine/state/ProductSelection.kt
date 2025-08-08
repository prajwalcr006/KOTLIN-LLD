package com.prajwalcr.kotlin_lld_prajwal.vending_machine.state

import com.prajwalcr.kotlin_lld_prajwal.vending_machine.VendingMachine
import com.prajwalcr.kotlin_lld_prajwal.vending_machine.exceptions.EmptySlotException
import com.prajwalcr.kotlin_lld_prajwal.vending_machine.exceptions.InsufficientFundsException
import com.prajwalcr.kotlin_lld_prajwal.vending_machine.exceptions.InvalidSlotException
import com.prajwalcr.kotlin_lld_prajwal.vending_machine.exceptions.InvalidStateException
import com.prajwalcr.kotlin_lld_prajwal.vending_machine.inventory.Item

class ProductSelection: State {
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
        try {
            val item = machine.inventory.getItem(slotNumber, machine.getUserAmount())
            println("Product added to cart!!")
            machine.setItemToCart(item)
            machine.setMachineState(ProductDispenser())
        } catch (ex: Exception) {
            println(ex.message)
            when(ex) {
                is InvalidSlotException -> {
                    println("Please enter valid slot")
                }
                is InsufficientFundsException -> {
                    println("please enter more cash")
                    machine.setMachineState(HasMoney())
                }
                is EmptySlotException -> {
                    cancelTransaction(machine)
                }
            }
        }
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