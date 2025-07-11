package com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.utils

import com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.parkingSpot.ParkingSpot

data class Ticket(
    val entryTime: Long,
    val parkingSpot: ParkingSpot
)