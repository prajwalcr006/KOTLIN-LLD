package com.prajwalcr.kotlin_lld_prajwal.atm

import com.prajwalcr.kotlin_lld_prajwal.atm.bank.Account
import com.prajwalcr.kotlin_lld_prajwal.atm.bank.Denomination
import com.prajwalcr.kotlin_lld_prajwal.atm.bank.User

fun main() {
    val atm = ATM()
    val account = Account()
    account.setBalance(15000)
    val user = User("prajwal cr", account)

    try {
        atm.getState().addCashToAtm(atm,
            listOf(
                Denomination.ONE_HUNDRED,
                Denomination.ONE_HUNDRED,
                Denomination.ONE_HUNDRED,
                Denomination.ONE_HUNDRED,
                Denomination.TWO_HUNDRED,
                Denomination.TWO_HUNDRED,
                Denomination.TWO_HUNDRED,
                Denomination.FIVE_HUNDRED,
                Denomination.FIVE_HUNDRED,
                Denomination.FIVE_HUNDRED,
                Denomination.FIVE_HUNDRED,
            )
        )


    } catch (ex: Exception) {
        println("Exception: $ex")
    }
}