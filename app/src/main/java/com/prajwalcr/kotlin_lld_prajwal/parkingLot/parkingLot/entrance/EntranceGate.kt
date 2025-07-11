package com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.entrance

import com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.utils.Ticket
import com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.vehicle.Vehicle

abstract class EntranceGate() {
    abstract fun generateTicket(vehicle: Vehicle): Ticket?
}