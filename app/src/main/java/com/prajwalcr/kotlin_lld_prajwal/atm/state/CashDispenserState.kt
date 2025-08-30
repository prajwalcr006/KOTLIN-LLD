package com.prajwalcr.kotlin_lld_prajwal.atm.state

import com.prajwalcr.kotlin_lld_prajwal.atm.ATM
import com.prajwalcr.kotlin_lld_prajwal.atm.bank.Card
import com.prajwalcr.kotlin_lld_prajwal.atm.bank.Denomination
import com.prajwalcr.kotlin_lld_prajwal.atm.exception.IllegalStateException

class CashDispenserState: State {
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

    override fun dispenseCash(atm: ATM): List<Denomination>? {
        return try {
            atm.setState(ReadyState())
            println("Card Removed!!")
            atm.removeCard()
            atm.getCardDetails().getUserDetails().account.setBalance(20)
            println("")
            println("Cash Dispensed!!")
            return atm.getUserDenominationList()
        } catch (ex: Exception) {
            println("Exception in dispensingCash!!")
            atm.setState(ErrorState())
            atm.getState().displayErrorMessage(atm, ex)
            null
        }
    }

    override fun displayErrorMessage(atm: ATM, ex: Exception) {
        throw IllegalStateException()
    }

    override fun cancelTransaction(atm: ATM) {
        throw IllegalStateException()
    }
}