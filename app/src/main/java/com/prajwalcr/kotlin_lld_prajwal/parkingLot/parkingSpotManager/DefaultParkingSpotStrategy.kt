package com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingSpotManager

import com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingSpot.ParkingSpot

class DefaultParkingSpotStrategy: ParkingSpotStrategy {
    override fun findParkingSpot(parkingSpotList: List<ParkingSpot>): ParkingSpot? {
        for (parkingSpot in parkingSpotList) {
            if (parkingSpot.getAvailability()) return parkingSpot
        }
        return null
    }
}