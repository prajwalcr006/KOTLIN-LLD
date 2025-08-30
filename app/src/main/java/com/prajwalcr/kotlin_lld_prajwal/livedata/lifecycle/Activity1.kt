package com.prajwalcr.kotlin_lld_prajwal.livedata.lifecycle

import com.prajwalcr.kotlin_lld_prajwal.livedata.LiveData
import com.prajwalcr.kotlin_lld_prajwal.livedata.observer.Observer
import java.util.Objects

class Activity1(
    private val liveData: LiveData<Int>
): LifecycleOwner {
    private val lifecycle = Lifecycle1()

    override fun getLifeCycle(): Lifecycle = lifecycle

    fun onCreate() {
        lifecycle.changeLifecycleState(LifecycleState.CREATED)
    }

    fun onStart() {
        lifecycle.changeLifecycleState(LifecycleState.STARTED)
    }

    fun onResume() {
        liveData.observe(
            this,
            observer = object: Observer<Int> {
                override fun onChanged(data: Int?) {
                    println("Live data in Activity 1 changed: Data = $data")
                }
            }
        )
    }

    fun onStop() {
        lifecycle.changeLifecycleState(LifecycleState.STOPPED)
    }

    fun onDestroy() {
        lifecycle.changeLifecycleState(LifecycleState.DESTROYED)
    }
}