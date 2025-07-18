package com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.parkingSpotManager

import com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.vehicle.VehicleType

class ParkingSpotManagerFactory {
    fun getParkingSpotManager(vehicleType: VehicleType): ParkingSpotManager {
        return when (vehicleType) {
            VehicleType.TWO_WHEELER -> TwoWheelerParkingSpotManager()
            VehicleType.FOUR_WHEELER -> FourWheelerParkingSpotManager()
        }
    }
}