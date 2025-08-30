package com.prajwalcr.kotlin_lld_prajwal.livedata.lifecycle

class Lifecycle1: Lifecycle {

    private var state: LifecycleState = LifecycleState.CREATED

    private val lifecycleObserverList: MutableList<LifecycleObserver> = mutableListOf()

    override fun getCurrentState(): LifecycleState = state

    override fun registerObserver(lifecycleObserver: LifecycleObserver) {
        lifecycleObserverList.add(lifecycleObserver)
    }

    override fun removeObserver(lifecycleObserver: LifecycleObserver) {
        lifecycleObserverList.remove(lifecycleObserver)
    }

    fun changeLifecycleState(state: LifecycleState) {
        this.state = state

        lifecycleObserverList.forEach { observers ->
            observers.onStateChanged(state)
        }
    }
}