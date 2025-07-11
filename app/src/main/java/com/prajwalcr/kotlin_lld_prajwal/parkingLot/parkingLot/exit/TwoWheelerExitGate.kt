package com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.exit

import com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.parkingSpot.ParkingSpot
import com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.parkingSpotManager.ParkingSpotManager
import com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.vehicle.Vehicle

class TwoWheelerExitGate(
    private val pricingStrategy: PricingStrategy,
    private val parkingSpotManager: ParkingSpotManager
): ExitGate {
    override fun removeVehicle(vehicle: Vehicle): Double? {
        val ticket = vehicle.getTicket()
        return ticket?.let {
            val parkingSpot = it.parkingSpot
            val totalTimeInMilliSeconds = System.currentTimeMillis() - it.entryTime
            val fare = computeCost(totalTimeInMilliSeconds, parkingSpot)
            parkingSpotManager.removeVehicle(parkingSpot,vehicle)
            fare
        }
    }

    private fun computeCost(
        totalTimeInMilliSeconds: Long,
        parkingSpot: ParkingSpot
    ): Double {
        return pricingStrategy.calculateFare(totalTimeInMilliSeconds, parkingSpot)
    }
}