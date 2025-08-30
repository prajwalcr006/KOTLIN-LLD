package com.prajwalcr.kotlin_lld_prajwal.livedata

import com.prajwalcr.kotlin_lld_prajwal.livedata.lifecycle.LifecycleOwner
import com.prajwalcr.kotlin_lld_prajwal.livedata.observer.Observer
import com.prajwalcr.kotlin_lld_prajwal.livedata.observer.ObserverWrapper
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

open class LiveData<T> {
    private var version = 0
    private var data: T? = null
    private var previousActiveCount = 0

    private val lock = Any()

    private val observerMap = ConcurrentHashMap<Observer<T>, ObserverWrapper<T>>()

    fun observe(lifecycleOwner: LifecycleOwner, observer: Observer<T>) {
        synchronized(lock) {
            val wrapper = ObserverWrapper(observer, lifecycleOwner, this)

            observerMap.remove(observer)
            observerMap[observer] = wrapper

            wrapper.owner.getLifeCycle().registerObserver(wrapper)

            considerNotify()

            if (data != null && wrapper.shouldBeActive() && wrapper.version < version) {
                wrapper.version = version
                observer.onChanged(data)
            }
        }
    }

    protected open fun setValue(data: T) {
        version++
        this.data = data
        dispatchValue(data)
    }

    protected open fun postValue(data: T) {
        setValue(data)
    }

    private fun dispatchValue(data: T) {
        synchronized(lock) {
            considerNotify()

            observerMap.forEach { (observer, wrapper) ->
                if (wrapper.shouldBeActive() && wrapper.version < version) {
                    wrapper.version = version
                    observer.onChanged(data)
                }
            }
        }
    }

    fun removeObserver(observer: Observer<T>) {
        synchronized(lock) {
            val wrapper = observerMap.remove(observer)
            wrapper?.owner?.getLifeCycle()?.removeObserver(wrapper)
        }
    }

    fun getValue() = data

    protected fun onActive() { }

    protected fun onInactive() { }

    fun considerNotify() {
        val currentActiveObservers = observerMap.values.count { it.shouldBeActive() }

        if (currentActiveObservers > 0 && previousActiveCount == 0) {
            onActive()
        }

        if (currentActiveObservers == 0 && previousActiveCount > 0) {
            onInactive()
        }

        previousActiveCount = currentActiveObservers
    }
}