package com.prajwalcr.kotlin_lld_prajwal.parkingLot.exit

import com.prajwalcr.kotlin_lld_prajwal.parkingLot.vehicle.Vehicle

interface ExitGate {
    fun removeVehicle(vehicle: Vehicle): Double?
}