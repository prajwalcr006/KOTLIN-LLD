package com.prajwalcr.kotlin_lld_prajwal.custom_viewmodel

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    val mainActivity = MainActivity()

    runBlocking {
        mainActivity.onCreate()
        delay(1000)
        mainActivity.onStart()
        delay(1000)
        mainActivity.onResume()
        delay(1000)
        mainActivity.onDestroy(isFinishing = false)
        delay(2500)
        mainActivity.onCreate()
        delay(1000)
        mainActivity.onStart()
        delay(1000)
        mainActivity.onResume()
        delay(1000)
        mainActivity.onDestroy(isFinishing = true)
        delay(2000)
    }
}