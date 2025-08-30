package com.prajwalcr.kotlin_lld_prajwal.atm.state

import com.prajwalcr.kotlin_lld_prajwal.atm.ATM
import com.prajwalcr.kotlin_lld_prajwal.atm.bank.Card
import com.prajwalcr.kotlin_lld_prajwal.atm.bank.Denomination
import com.prajwalcr.kotlin_lld_prajwal.atm.exception.IllegalStateException

class FetchATMCashState: State {
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
        try {
            val denomination = atm.atmCashBox.fetchCash(atm, amount)
            atm.setUserDenominationList(denomination)
            atm.setState(CashDispenserState())
        } catch (ex: Exception) {
            println("Exception in Fetch Cash From ATM Operation!!")
            atm.setState(ErrorState())
            atm.getState().displayErrorMessage(atm, ex)
        }
    }

    override fun dispenseCash(atm: ATM): List<Denomination> {
        throw IllegalStateException()
    }

    override fun displayErrorMessage(atm: ATM, ex: Exception) {
        throw IllegalStateException()
    }

    override fun cancelTransaction(atm: ATM) {
        try {
            println("Transaction cancelled!!")
            val card = atm.removeCard()
            println("Card: $card removed!!")
            atm.setState(ReadyState())
        } catch (ex: Exception) {
            println("Exception in Cancel Operation!!")
            atm.setState(ErrorState())
            atm.getState().displayErrorMessage(atm, ex)
        }
    }
}