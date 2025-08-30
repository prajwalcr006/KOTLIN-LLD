package com.prajwalcr.kotlin_lld_prajwal.atm.state

import com.prajwalcr.kotlin_lld_prajwal.atm.ATM
import com.prajwalcr.kotlin_lld_prajwal.atm.bank.Card
import com.prajwalcr.kotlin_lld_prajwal.atm.bank.Denomination
import com.prajwalcr.kotlin_lld_prajwal.atm.exception.CustomException
import com.prajwalcr.kotlin_lld_prajwal.atm.exception.IllegalStateException

class WithDrawState: State {
    override fun addCashToAtm(atm: ATM, denominations: List<Denomination>) {
        throw IllegalStateException()
    }

    override fun insertCard(atm: ATM, card: Card) {
        throw IllegalStateException()
    }

    override fun withdrawCash(atm: ATM, amount: Long) {
        try {
            val userBalance = atm.getCardDetails().getUserDetails().account.getBalance()
            if (userBalance < amount) {
                atm.setState(ErrorState())
                atm.getState().displayErrorMessage(atm, CustomException("Insufficient Balance"))
            } else {
                atm.setUserRequestedAmount(amount)
            }
        } catch (ex: Exception) {
            println("Exception while withdrawing cash!!")
            atm.setState(ErrorState())
            atm.getState().displayErrorMessage(atm, ex)
        }
    }

    override fun validatePin(atm: ATM, pin: Int) {
        try {
            val isPinValid = atm.getCardDetails().validateId(pin)
            if (isPinValid) {
                atm.setState(FetchATMCashState())
            } else {
                atm.setState(ErrorState())
                atm.getState().displayErrorMessage(atm, CustomException("Invalid Pin"))
            }
        } catch (ex: Exception) {
            println("Exception Validating Pin!!")
            atm.setState(ErrorState())
            atm.getState().displayErrorMessage(atm, ex)
        }
    }

    override fun fetchCashFromATM(atm: ATM, amount: Long) {
        throw IllegalStateException()
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