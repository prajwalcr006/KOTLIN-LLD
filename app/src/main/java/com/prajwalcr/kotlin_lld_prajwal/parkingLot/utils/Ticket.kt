package com.prajwalcr.kotlin_lld_prajwal.parkingLot.utils

import com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingSpot.ParkingSpot

data class Ticket(
    val entryTime: Long,
    val parkingSpot: ParkingSpot
)