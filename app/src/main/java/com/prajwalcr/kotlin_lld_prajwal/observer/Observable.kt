package com.prajwalcr.kotlin_lld_prajwal.observer

open class Observable {
    private val observerList: MutableList<Observer> = mutableListOf()

    fun addObserver(observer: Observer) {
        observerList.add(observer)
    }

    fun removeObserver(observer: Observer) {
        observerList.remove(observer)
    }

    fun notifyObservers(message: String? = null) {
        observerList.forEach { observer ->
            observer.update(this, message)
        }
    }
}