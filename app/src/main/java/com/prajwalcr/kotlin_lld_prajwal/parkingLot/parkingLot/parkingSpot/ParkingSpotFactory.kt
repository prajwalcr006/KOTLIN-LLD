package com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.parkingSpot

import com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.vehicle.VehicleType

class ParkingSpotFactory {
    fun getParkingSpot(
        parkingSpotNumber: Int,
        vehicleType: VehicleType
    ): ParkingSpot {
        return when (vehicleType) {
            VehicleType.TWO_WHEELER -> TwoWheelerParkingSpot(parkingSpotNumber)
            VehicleType.FOUR_WHEELER -> FourWheelerParkingSpot(parkingSpotNumber)
        }
    }
}