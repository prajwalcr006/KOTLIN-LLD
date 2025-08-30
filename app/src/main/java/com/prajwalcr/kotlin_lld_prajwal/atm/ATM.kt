package com.prajwalcr.kotlin_lld_prajwal.atm

import com.prajwalcr.kotlin_lld_prajwal.atm.bank.Card
import com.prajwalcr.kotlin_lld_prajwal.atm.bank.Denomination
import com.prajwalcr.kotlin_lld_prajwal.atm.exception.NullValueException
import com.prajwalcr.kotlin_lld_prajwal.atm.process.ATMCashBox
import com.prajwalcr.kotlin_lld_prajwal.atm.state.ReadyState
import com.prajwalcr.kotlin_lld_prajwal.atm.state.State
import com.prajwalcr.kotlin_lld_prajwal.state.Log

class ATM {
    private var state: State = ReadyState()

    private var oneHundreds: Long = 0
    private var twoHundreds: Long = 0
    private var fiveHundreds: Long = 0

    private var card: Card? = null
    private var userRequestedAmount = 0L
    private var userDenominationList: List<Denomination>? = null

    val atmCashBox = ATMCashBox()

    fun getOneHundredsCount() = oneHundreds
    fun getTwoHundredsCount() = twoHundreds
    fun getFiveHundredsCount() = fiveHundreds

    fun setUserDenominationList(list: List<Denomination>) {
        userDenominationList = list
    }

    fun getUserDenominationList(): List<Denomination> {
        val t = userDenominationList
        userDenominationList = null
        return t ?: throw NullValueException()
    }

    fun setOneHundredsCount(count: Long) {
        oneHundreds = count
    }

    fun setTwoHundredsCount(count: Long) {
        twoHundreds = count
    }

    fun setFiveHundredsCount(count: Long) {
        fiveHundreds = count
    }

    fun getUserRequestedAmount() = userRequestedAmount

    fun setUserRequestedAmount(amount: Long) {
        userRequestedAmount = amount
    }

    fun getState() = state

    fun setState(state: State) {
        this.state = state
    }

    fun insertCard(card: Card) {
        this.card = card
    }

    fun getCardDetails(): Card {
        return card ?: throw NullValueException()
    }

    fun removeCard(): Card {
        val tCard = card
        card = null
        return tCard ?: throw NullValueException()
    }

    fun addCash(denominations: List<Denomination>) {
        denominations.forEach { cash ->
            when (cash) {
                Denomination.ONE_HUNDRED -> oneHundreds++
                Denomination.TWO_HUNDRED -> twoHundreds++
                Denomination.FIVE_HUNDRED -> fiveHundreds++
            }
        }
    }


}