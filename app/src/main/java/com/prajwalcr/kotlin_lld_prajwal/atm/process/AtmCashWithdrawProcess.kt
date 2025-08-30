package com.prajwalcr.kotlin_lld_prajwal.atm.process

import com.prajwalcr.kotlin_lld_prajwal.atm.ATM
import com.prajwalcr.kotlin_lld_prajwal.atm.bank.Denomination
import com.prajwalcr.kotlin_lld_prajwal.atm.exception.CustomException

open class AtmCashWithdrawProcess(
    private val cashWithdrawProcess: AtmCashWithdrawProcess?
) {

    open fun fetchATMCash(atm: ATM, amount: Long): List<Denomination> {
        return cashWithdrawProcess?.fetchATMCash(atm, amount) ?: throw CustomException("Insufficient Cash in ATM!!")
    }
}