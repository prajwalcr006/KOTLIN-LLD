package com.prajwalcr.kotlin_lld_prajwal.adapter

class WeightAdapterImpl(
    private val weightMachine: WeightMachine
): WeightAdapter {
    override fun getWeightInKg(): Double {
        return weightMachine.getWeightInPounds() * 0.45
    }
}