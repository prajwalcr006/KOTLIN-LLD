package com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.exit

import com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingLot.vehicle.Vehicle

interface ExitGate {
    fun removeVehicle(vehicle: Vehicle): Double?
}