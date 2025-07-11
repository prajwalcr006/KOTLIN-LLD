package com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.parkingSpot

import com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.vehicle.Vehicle

class TwoWheelerParkingSpot(
    private val parkingSpotNumber: Int,
): ParkingSpot(parkingSpotNumber, pricePerMinute = 0.5) {
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