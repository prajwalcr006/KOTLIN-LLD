package com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.parkingSpotManager

import com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.parkingSpot.ParkingSpot
import com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.vehicle.Vehicle

abstract class ParkingSpotManager(
    protected val parkingSpotList: MutableList<ParkingSpot> = mutableListOf(),
    protected val parkingSpotStrategy: ParkingSpotStrategy
) {
    abstract fun addParkingSpot(parkingSpot: ParkingSpot)
    abstract fun removeParkingSpot(parkingSpot: ParkingSpot)
    abstract fun getParkingSpot(): ParkingSpot?

    abstract fun parkVehicle(parkingSpot: ParkingSpot, vehicle: Vehicle)
    abstract fun removeVehicle(parkingSpot: ParkingSpot, vehicle: Vehicle)
}