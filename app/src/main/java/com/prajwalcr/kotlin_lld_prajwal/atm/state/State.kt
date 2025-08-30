package com.prajwalcr.kotlin_lld_prajwal.atm.state

import com.prajwalcr.kotlin_lld_prajwal.atm.ATM
import com.prajwalcr.kotlin_lld_prajwal.atm.bank.Card
import com.prajwalcr.kotlin_lld_prajwal.atm.bank.Denomination

interface State {
    fun addCashToAtm(atm: ATM, denominations: List<Denomination>)
    fun insertCard(atm: ATM, card: Card)
    fun withdrawCash(atm: ATM, amount: Long)
    fun validatePin(atm: ATM, pin: Int)
    fun fetchCashFromATM(atm: ATM, amount: Long)
    fun dispenseCash(atm: ATM): List<Denomination>?
    fun displayErrorMessage(atm: ATM, ex: Exception)
    fun cancelTransaction(atm: ATM)
}