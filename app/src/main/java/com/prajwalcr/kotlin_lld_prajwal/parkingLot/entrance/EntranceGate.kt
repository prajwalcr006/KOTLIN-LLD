package com.prajwalcr.kotlin_lld_prajwal.parkingLot.entrance

import com.prajwalcr.kotlin_lld_prajwal.parkingLot.utils.Ticket
import com.prajwalcr.kotlin_lld_prajwal.parkingLot.vehicle.Vehicle

abstract class EntranceGate() {
    abstract fun generateTicket(vehicle: Vehicle): Ticket?
}