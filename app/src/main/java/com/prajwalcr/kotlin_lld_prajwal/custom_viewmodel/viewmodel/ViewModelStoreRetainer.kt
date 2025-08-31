package com.prajwalcr.kotlin_lld_prajwal.custom_viewmodel.viewmodel

class ViewModelStoreRetainer {
    private val viewModelStoreMap: MutableMap<String, ViewModelStore> = mutableMapOf()

    fun retain(key: String, viewModelStore: ViewModelStore) {
        viewModelStoreMap[key] = viewModelStore
    }

    fun retrieve(key: String): ViewModelStore? = viewModelStoreMap.remove(key)
}