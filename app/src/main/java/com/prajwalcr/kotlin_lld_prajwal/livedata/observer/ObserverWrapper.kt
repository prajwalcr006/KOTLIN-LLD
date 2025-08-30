package com.prajwalcr.kotlin_lld_prajwal.livedata.observer

import com.prajwalcr.kotlin_lld_prajwal.livedata.LiveData
import com.prajwalcr.kotlin_lld_prajwal.livedata.lifecycle.LifecycleObserver
import com.prajwalcr.kotlin_lld_prajwal.livedata.lifecycle.LifecycleOwner
import com.prajwalcr.kotlin_lld_prajwal.livedata.lifecycle.LifecycleState

class ObserverWrapper<T>(
    private val observer: Observer<T>,
    val owner: LifecycleOwner,
    private val liveData: LiveData<T>,
): LifecycleObserver {
    var version = -1

    fun shouldBeActive(): Boolean {
        val ownerState = owner.getLifeCycle().getCurrentState()
        return ownerState == LifecycleState.STARTED || ownerState == LifecycleState.RESUMED
    }

    override fun onStateChanged(lifecycleState: LifecycleState) {
        liveData.considerNotify()
    }
}