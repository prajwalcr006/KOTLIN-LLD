package com.prajwalcr.kotlin_lld_prajwal.parkingLot.exit

import com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingSpot.ParkingSpot
import com.prajwalcr.kotlin_lld_prajwal.parkingLot.vehicle.Vehicle

interface PricingStrategy {
    fun calculateFare(totalTimeInMilliSeconds: Long, parkingSpot: ParkingSpot): Double
}