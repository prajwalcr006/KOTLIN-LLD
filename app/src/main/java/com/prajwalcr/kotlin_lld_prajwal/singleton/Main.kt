package com.prajwalcr.kotlin_lld_prajwal.singleton

fun main() {
    val instance1 = Singleton.getInstance()
    val instance2 = Singleton.getInstance()

    println("Is Instance 1 and Instance 2 same? ${instance1 === instance2}")
}