package com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingSpotManager

import com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingSpot.ParkingSpot
import com.prajwalcr.kotlin_lld_prajwal.parkingLot.vehicle.Vehicle

class TwoWheelerParkingSpotManager: ParkingSpotManager(
    parkingSpotStrategy = DefaultParkingSpotStrategy()
) {
    override fun addParkingSpot(parkingSpot: ParkingSpot) {
        parkingSpotList.add(parkingSpot)
    }

    override fun removeParkingSpot(parkingSpot: ParkingSpot) {
        parkingSpotList.remove(parkingSpot)
    }

    override fun getParkingSpot(): ParkingSpot? {
        return parkingSpotStrategy.findParkingSpot(parkingSpotList)
    }

    override fun parkVehicle(parkingSpot: ParkingSpot, vehicle: Vehicle) {
        parkingSpot.addVehicle(vehicle)
    }

    override fun removeVehicle(parkingSpot: ParkingSpot, vehicle: Vehicle) {
        parkingSpot.removeVehicle(vehicle)
    }

}