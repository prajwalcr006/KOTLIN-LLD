package com.prajwalcr.kotlin_lld_prajwal.atm.state

import com.prajwalcr.kotlin_lld_prajwal.atm.ATM
import com.prajwalcr.kotlin_lld_prajwal.atm.bank.Card
import com.prajwalcr.kotlin_lld_prajwal.atm.bank.Denomination
import com.prajwalcr.kotlin_lld_prajwal.atm.exception.IllegalStateException

class ErrorState: State {
    override fun addCashToAtm(atm: ATM, denominations: List<Denomination>) {
        throw IllegalStateException()
    }

    override fun insertCard(atm: ATM, card: Card) {
        throw IllegalStateException()
    }

    override fun withdrawCash(atm: ATM, amount: Long) {
        throw IllegalStateException()
    }

    override fun validatePin(atm: ATM, pin: Int) {
        throw IllegalStateException()
    }

    override fun fetchCashFromATM(atm: ATM, amount: Long) {
        throw IllegalStateException()
    }

    override fun dispenseCash(atm: ATM): List<Denomination> {
        throw IllegalStateException()
    }

    override fun displayErrorMessage(atm: ATM, ex: Exception) {
        try {
            println("Transaction cancelled!!")
            val card = atm.removeCard()
            println("Card: $card removed!!")
            atm.setState(ReadyState())
        } catch (ex: Exception) {
            println("Exception in Displaying Error!! EX: $ex")
            atm.setState(ReadyState())
        }
    }

    override fun cancelTransaction(atm: ATM) {
        throw IllegalStateException()
    }
}