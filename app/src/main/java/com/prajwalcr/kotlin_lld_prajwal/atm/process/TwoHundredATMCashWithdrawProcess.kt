package com.prajwalcr.kotlin_lld_prajwal.atm.process

import com.prajwalcr.kotlin_lld_prajwal.atm.ATM
import com.prajwalcr.kotlin_lld_prajwal.atm.bank.Denomination

class TwoHundredATMCashWithdrawProcess(
    private val cashWithdrawProcess: AtmCashWithdrawProcess? = null
): AtmCashWithdrawProcess(cashWithdrawProcess) {

    override fun fetchATMCash(atm: ATM, amount: Long): List<Denomination> {
        val atmTwoHundredNotes = atm.getTwoHundredsCount()
        val requiredTwoHundredNotes = amount / Denomination.TWO_HUNDRED.value

        val twoHundredNotes = if (atmTwoHundredNotes > requiredTwoHundredNotes) { requiredTwoHundredNotes } else { atmTwoHundredNotes }

        atm.setTwoHundredsCount(atmTwoHundredNotes - twoHundredNotes)

        val remainingAmount = amount - (twoHundredNotes * Denomination.TWO_HUNDRED.value)

        val denominationList: MutableList<Denomination> = mutableListOf()

        for (i in 1..twoHundredNotes) {
            denominationList.add(Denomination.TWO_HUNDRED)
        }

        if (remainingAmount > 0) {
            cashWithdrawProcess?.fetchATMCash(atm, remainingAmount)?.let {
                denominationList.addAll(it)
            }
        }

        return denominationList
    }
}