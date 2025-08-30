package com.prajwalcr.kotlin_lld_prajwal.livedata.observer

interface Observer<T> {
    fun onChanged(data: T?)
}