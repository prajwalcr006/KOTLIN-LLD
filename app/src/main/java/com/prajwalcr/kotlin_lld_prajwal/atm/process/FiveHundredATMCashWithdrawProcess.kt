package com.prajwalcr.kotlin_lld_prajwal.atm.process

import com.prajwalcr.kotlin_lld_prajwal.atm.ATM
import com.prajwalcr.kotlin_lld_prajwal.atm.bank.Denomination

class FiveHundredATMCashWithdrawProcess(
    private val cashWithdrawProcess: AtmCashWithdrawProcess? = null
): AtmCashWithdrawProcess(cashWithdrawProcess) {

    override fun fetchATMCash(atm: ATM, amount: Long): List<Denomination> {
        val atmFiveHundredNotes = atm.getFiveHundredsCount()
        val requiredFiveHundredNotes = amount / Denomination.FIVE_HUNDRED.value

        val fiveHundredNotes = if (atmFiveHundredNotes > requiredFiveHundredNotes) { requiredFiveHundredNotes } else { atmFiveHundredNotes }

        atm.setFiveHundredsCount(atmFiveHundredNotes - fiveHundredNotes)

        val remainingAmount = amount - (fiveHundredNotes * Denomination.FIVE_HUNDRED.value)

        val denominationList: MutableList<Denomination> = mutableListOf()

        for (i in 1..fiveHundredNotes) {
            denominationList.add(Denomination.FIVE_HUNDRED)
        }

        if (remainingAmount > 0) {
            cashWithdrawProcess?.fetchATMCash(atm, remainingAmount)?.let {
                denominationList.addAll(it)
            }
        }

        return denominationList
    }
}