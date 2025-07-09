package com.prajwalcr.kotlin_lld_prajwal.parkingLot.exit

import com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingSpot.ParkingSpot

class HourlyPricingStrategy: PricingStrategy {
    override fun calculateFare(totalTimeInMilliSeconds: Long, parkingSpot: ParkingSpot): Double {
        val totalHours = totalTimeInMilliSeconds / (1000 * 60 * 60)
        return totalHours * (parkingSpot.getPricePerMinute() * 60)
    }
}