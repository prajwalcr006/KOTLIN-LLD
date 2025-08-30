package com.prajwalcr.kotlin_lld_prajwal.atm.process

import com.prajwalcr.kotlin_lld_prajwal.atm.ATM
import com.prajwalcr.kotlin_lld_prajwal.atm.bank.Denomination

class OneHundredATMCashWithdrawProcess(
    private val cashWithdrawProcess: AtmCashWithdrawProcess? = null
): AtmCashWithdrawProcess(cashWithdrawProcess) {

    override fun fetchATMCash(atm: ATM, amount: Long): List<Denomination> {
        val atmOneHundredNotes = atm.getOneHundredsCount()
        val requiredOneHundredNotes = amount / Denomination.ONE_HUNDRED.value

        val oneHundredNotes = if (atmOneHundredNotes > requiredOneHundredNotes) { requiredOneHundredNotes } else { atmOneHundredNotes }

        atm.setOneHundredsCount(atmOneHundredNotes - oneHundredNotes)

        val remainingAmount = amount - (oneHundredNotes * Denomination.ONE_HUNDRED.value)

        val denominationList: MutableList<Denomination> = mutableListOf()

        for (i in 1..oneHundredNotes) {
            denominationList.add(Denomination.ONE_HUNDRED)
        }

        if (remainingAmount > 0) {
            cashWithdrawProcess?.fetchATMCash(atm, remainingAmount)?.let {
                denominationList.addAll(it)
            }
        }

        return denominationList
    }
}