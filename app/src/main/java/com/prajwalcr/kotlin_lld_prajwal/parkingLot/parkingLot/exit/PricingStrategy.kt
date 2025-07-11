package com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.exit

import com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.parkingSpot.ParkingSpot

interface PricingStrategy {
    fun calculateFare(totalTimeInMilliSeconds: Long, parkingSpot: ParkingSpot): Double
}