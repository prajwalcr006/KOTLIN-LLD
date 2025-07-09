package com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingSpot

import com.prajwalcr.kotlin_lld_prajwal.parkingLot.vehicle.Vehicle

class FourWheelerParkingSpot(
    private val parkingSpotNumber: Int
): ParkingSpot(parkingSpotNumber, pricePerMinute = 1.0) {
    override fun addVehicle(vehicle: Vehicle) {
        isAvailable = false
        this.vehicle = vehicle
        usageCount++
    }

    override fun removeVehicle(vehicle: Vehicle) {
        isAvailable = true
        this.vehicle = null
    }
}