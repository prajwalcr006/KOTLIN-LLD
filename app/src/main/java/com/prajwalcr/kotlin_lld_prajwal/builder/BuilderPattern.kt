package com.prajwalcr.kotlin_lld_prajwal.builder

fun main() {
    val student = StudentBuilder()
        .setAge(20)
        .setName("Prajwal C R")
        .setSubjects(listOf("DSA", "DEV", "Design"))
        .build()

    println("Student created is $student")
}