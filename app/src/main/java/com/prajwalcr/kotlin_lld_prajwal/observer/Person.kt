package com.prajwalcr.kotlin_lld_prajwal.observer

class Person(
    private val name: String,
    private val email: String,
    private val iPhoneObservable: IphoneObservable,
    private val samsungObservable :SamsungObservable
): Observer {

    fun getIphone() {
        val result = iPhoneObservable.purchaseIphone()
        if (!result) {
            println("${name}: No Iphone Available")
            iPhoneObservable.addObserver(this)
        } else {
            println("${name}: Got Iphone")
        }
    }

    fun getSamsung() {
        val result = samsungObservable.purchaseSamsung()
        if (!result) {
            println("${name}: No Samsung Available")
            samsungObservable.addObserver(this)
        } else {
            println("${name}: Got Samsung")
        }
    }

    override fun update(observable: Observable, message: String?) {
        when (observable) {
            is IphoneObservable -> {
                println("${name}: $message")
            }

            is SamsungObservable -> {
                println("${name}: $message")
            }
        }
    }
}