package com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingSpotManager

import com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingSpot.ParkingSpot

interface ParkingSpotStrategy {
    fun findParkingSpot(
        parkingSpotList: List<ParkingSpot>
    ): ParkingSpot?
}