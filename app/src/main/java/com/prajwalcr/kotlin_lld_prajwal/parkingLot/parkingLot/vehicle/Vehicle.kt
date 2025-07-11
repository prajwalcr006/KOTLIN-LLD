package com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.vehicle

import com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.utils.Ticket

class Vehicle(
    private val vehicleNumber: String,
    private val vehicleType: VehicleType,
    private var ticket: Ticket? = null
) {
    fun getTicket() = ticket
    fun getVehicleNumber() = vehicleNumber
    fun getVehicleType() = vehicleType

    fun setTicket(ticket: Ticket) {
        this.ticket = ticket
    }
}