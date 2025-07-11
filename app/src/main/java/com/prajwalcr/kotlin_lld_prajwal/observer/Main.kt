package com.prajwalcr.kotlin_lld_prajwal.observer

fun main() {
    val iphoneObservable = IphoneObservable()
    val samsungObservable = SamsungObservable()
    val person1 = Person(
        name = "John",
        email = "jhn@gmail.com",
        iphoneObservable,
        samsungObservable
    )

    val person2 = Person(
        name = "Ben",
        email = "ben@gmail.com",
        iphoneObservable,
        samsungObservable
    )

    val person3 = Person(
        name = "Max",
        email = "max@gmail.com",
        iphoneObservable,
        samsungObservable
    )

    val person4 = Person(
        name = "Qwen",
        email = "qwen@gmail.com",
        iphoneObservable,
        samsungObservable
    )

    iphoneObservable.addIphone(1)
    samsungObservable.addSamsung(1)

    person1.getIphone()
    person2.getSamsung()
    person3.getIphone()
    person4.getSamsung()

    iphoneObservable.addIphone(10)
    samsungObservable.addSamsung(10)
}