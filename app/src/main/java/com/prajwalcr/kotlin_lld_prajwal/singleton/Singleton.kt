package com.prajwalcr.kotlin_lld_prajwal.singleton

import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

class Singleton private constructor() {
    companion object {
        private var instance: Singleton? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getInstance(): Singleton {
            if (instance == null) {
                synchronized(this) {
                    instance = Singleton()
                }
            }
            return instance!!
        }
    }
}