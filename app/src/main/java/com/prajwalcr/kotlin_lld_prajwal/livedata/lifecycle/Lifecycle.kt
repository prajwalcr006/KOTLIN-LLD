package com.prajwalcr.kotlin_lld_prajwal.livedata.lifecycle

interface Lifecycle {
    fun getCurrentState(): LifecycleState
    fun registerObserver(lifecycleObserver: LifecycleObserver)
    fun removeObserver(lifecycleObserver: LifecycleObserver)
}