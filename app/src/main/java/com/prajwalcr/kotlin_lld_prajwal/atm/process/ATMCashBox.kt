package com.prajwalcr.kotlin_lld_prajwal.atm.process

import com.prajwalcr.kotlin_lld_prajwal.atm.ATM
import com.prajwalcr.kotlin_lld_prajwal.atm.bank.Denomination

class ATMCashBox {
    private val cashWithDrawProcess = FiveHundredATMCashWithdrawProcess(TwoHundredATMCashWithdrawProcess(OneHundredATMCashWithdrawProcess()))

    fun fetchCash(atm: ATM, amount: Long): List<Denomination> {
        return cashWithDrawProcess.fetchATMCash(atm, amount)
    }
}