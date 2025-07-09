package com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingSpotManager

import com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingSpot.ParkingSpot

class GetLeastUsedParkingSpotStrategy: ParkingSpotStrategy {
    private var leastUsedParkingSpot: ParkingSpot? = null
    private var minUsageCount = Int.MAX_VALUE
    override fun findParkingSpot(parkingSpotList: List<ParkingSpot>): ParkingSpot? {
        for (parkingSpot in parkingSpotList) {
            if (parkingSpot.getAvailability() && minUsageCount > parkingSpot.getCount()) {
                minUsageCount = parkingSpot.getCount()
                leastUsedParkingSpot = parkingSpot
            }
        }

        return leastUsedParkingSpot
    }
}