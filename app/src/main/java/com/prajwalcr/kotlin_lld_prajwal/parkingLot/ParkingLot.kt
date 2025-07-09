package com.prajwalcr.kotlin_lld_prajwal.parkingLot

import com.prajwalcr.kotlin_lld_prajwal.parkingLot.entrance.FourWheelerEntranceGate
import com.prajwalcr.kotlin_lld_prajwal.parkingLot.entrance.TwoWheelerEntranceGate
import com.prajwalcr.kotlin_lld_prajwal.parkingLot.exit.FourWheelerExitGate
import com.prajwalcr.kotlin_lld_prajwal.parkingLot.exit.HourlyPricingStrategy
import com.prajwalcr.kotlin_lld_prajwal.parkingLot.exit.MinutesPricingStrategy
import com.prajwalcr.kotlin_lld_prajwal.parkingLot.exit.TwoWheelerExitGate
import com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingSpot.ParkingSpotFactory
import com.prajwalcr.kotlin_lld_prajwal.parkingLot.parkingSpotManager.ParkingSpotManagerFactory
import com.prajwalcr.kotlin_lld_prajwal.parkingLot.vehicle.Vehicle
import com.prajwalcr.kotlin_lld_prajwal.parkingLot.vehicle.VehicleType

fun main() {
    val parkingSpotManagerFactory = ParkingSpotManagerFactory()
    val parkingSpotFactory = ParkingSpotFactory()
    val twoWheelerParkingSpotManager = parkingSpotManagerFactory.getParkingSpotManager(VehicleType.TWO_WHEELER)
    val fourWheelerParkingSpotManager = parkingSpotManagerFactory.getParkingSpotManager(VehicleType.FOUR_WHEELER)

    val twoWheelerEntranceGate = TwoWheelerEntranceGate(twoWheelerParkingSpotManager)
    val fourWheelerEntranceGate = FourWheelerEntranceGate(fourWheelerParkingSpotManager)

    val twoWheelerExitGate = TwoWheelerExitGate(
        MinutesPricingStrategy(),
        twoWheelerParkingSpotManager
    )

    val fourWheelerExitGate = FourWheelerExitGate(
        HourlyPricingStrategy(),
        fourWheelerParkingSpotManager
    )

    val twoWheelerVehicles = listOf(
        Vehicle("KA-01-HH-1234", VehicleType.TWO_WHEELER),
        Vehicle("KA-01-HH-9999", VehicleType.TWO_WHEELER),
        Vehicle("KA-01-BB-0001", VehicleType.TWO_WHEELER),
        Vehicle("KA-01-HH-7777", VehicleType.TWO_WHEELER),
        Vehicle("KA-01-HH-2701", VehicleType.TWO_WHEELER)
    )

    val fourWheelerVehicles = listOf(
        Vehicle("KA-01-HH-3113", VehicleType.FOUR_WHEELER),
        Vehicle("KA-01-P-333", VehicleType.FOUR_WHEELER),
        Vehicle("KA-01-HH-2701", VehicleType.FOUR_WHEELER),
        Vehicle("KA-01-HH-3142", VehicleType.FOUR_WHEELER),
        Vehicle("KA-21-B-5623", VehicleType.FOUR_WHEELER)
    )

    for (i in 1..4) {
        twoWheelerParkingSpotManager.addParkingSpot(
            parkingSpotFactory.getParkingSpot(i, VehicleType.TWO_WHEELER)
        )
    }

    for (i in 5..10) {
        fourWheelerParkingSpotManager.addParkingSpot(
            parkingSpotFactory.getParkingSpot(i, VehicleType.FOUR_WHEELER)
        )
    }

    for (vehicle in twoWheelerVehicles) {
        val ticket = twoWheelerEntranceGate.generateTicket(vehicle)

        if (ticket == null) {
            println("No parking Space Available For Vehicle $vehicle")
        } else {
            println("Vehicle $vehicle parked successfully. Ticket $ticket")
        }
        Thread.sleep(1000)
    }

    for (vehicle in fourWheelerVehicles) {
        val ticket = fourWheelerEntranceGate.generateTicket(vehicle)

        if (ticket == null) {
            println("No parking Space Available For Vehicle ${vehicle.getVehicleNumber()}")
        } else {
            vehicle.setTicket(ticket)
            println("Vehicle $vehicle parked successfully. Ticket $ticket")
        }
        Thread.sleep(1000)
    }

    for (vehicle in twoWheelerVehicles) {
        if (vehicle.getTicket() != null) {
            val fare = twoWheelerExitGate.removeVehicle(vehicle)
            println("Total fare for $vehicle is $fare")
        } else {
            println("Vehicle ${vehicle.getVehicleNumber()} has no ticket")
        }
        Thread.sleep(1000)
    }

    for (vehicle in fourWheelerVehicles) {
        if (vehicle.getTicket() != null) {
            val fare = fourWheelerExitGate.removeVehicle(vehicle)
            println("Total fare for ${vehicle.getVehicleNumber()} is $fare")
        } else {
            println("Vehicle ${vehicle.getVehicleNumber()} has no ticket")
        }
        Thread.sleep(1000)
    }
}