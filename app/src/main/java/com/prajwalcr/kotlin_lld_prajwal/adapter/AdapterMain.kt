package com.prajwalcr.kotlin_lld_prajwal.adapter

fun main() {
    val weightAdapter: WeightAdapter = WeightAdapterImpl(WeightMachine())

    val weightInKg = weightAdapter.getWeightInKg()

    println("Weight in kg is $weightInKg")
}