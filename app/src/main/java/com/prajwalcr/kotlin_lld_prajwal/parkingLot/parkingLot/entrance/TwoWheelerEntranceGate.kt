package com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.entrance

import com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.utils.Ticket
import com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.parkingSpotManager.ParkingSpotManager
import com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.vehicle.Vehicle

class TwoWheelerEntranceGate(
    private val parkingSpotManager: ParkingSpotManager
): EntranceGate() {

    override fun generateTicket(vehicle: Vehicle): Ticket? {
        val parkingSpot = parkingSpotManager.getParkingSpot()
        return if (parkingSpot != null) {
            parkingSpotManager.parkVehicle(parkingSpot, vehicle)
            Ticket(System.currentTimeMillis(), parkingSpot)
        } else {
            null
        }
    }
}