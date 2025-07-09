package com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingSpot

import com.prajwalcr.kotlin_lld_prajwal.parkingLot.vehicle.Vehicle

abstract class ParkingSpot(
    private val parkingSpotNumber: Int,
    private val pricePerMinute: Double
) {
    protected var isAvailable: Boolean = true
    protected var vehicle: Vehicle? = null
    protected var usageCount: Int = 0

    abstract fun addVehicle(vehicle: Vehicle)
    abstract fun removeVehicle(vehicle: Vehicle)

    fun getAvailability(): Boolean = isAvailable
    fun getCount() = usageCount
    fun getPricePerMinute() = pricePerMinute
}