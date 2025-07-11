package com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.exit

import com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.parkingSpot.ParkingSpot

class MinutesPricingStrategy: PricingStrategy {
    override fun calculateFare(totalTimeInMilliSeconds: Long, parkingSpot: ParkingSpot): Double {
        val totalMinutes = totalTimeInMilliSeconds / (1000 * 60)
        return totalMinutes * parkingSpot.getPricePerMinute()
    }
}