package com.prajwalcr.kotlin_lld_prajwal.custom_viewmodel.viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import java.io.Closeable

open class CustomViewModel {
    private var isCleared = false
    private val dataHolder: MutableMap<String, Any> = mutableMapOf()
    protected val viewModelScope = CoroutineScope(SupervisorJob())

    protected fun put(key: String, data: Any) {
        dataHolder[key] = data
    }

    protected open fun onCleared() {}

    protected fun get(key: String) = dataHolder[key]

    internal fun clear() {
        if (isCleared) return

        viewModelScope.cancel()

        dataHolder.values.forEach { data ->
            try {
                if (data is Closeable) {
                    data.close()
                }
            } catch (ex: Exception) {
                println("Exception in closing data: $data!! EX: $ex")
                throw ex
            }
        }
        dataHolder.clear()
        isCleared = true

        onCleared()
    }
}