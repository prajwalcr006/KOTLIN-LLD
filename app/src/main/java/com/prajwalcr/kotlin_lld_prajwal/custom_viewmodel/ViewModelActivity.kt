package com.prajwalcr.kotlin_lld_prajwal.custom_viewmodel

import com.prajwalcr.kotlin_lld_prajwal.custom_viewmodel.viewmodel.ViewModelProvider
import com.prajwalcr.kotlin_lld_prajwal.custom_viewmodel.viewmodel.ViewModelStore
import com.prajwalcr.kotlin_lld_prajwal.custom_viewmodel.viewmodel.ViewModelStoreRetainer

open class ViewModelActivity {
    private var shouldRetrieveViewModelStore = false

    private val globalViewModelStoreRetainer: ViewModelStoreRetainer = ViewModelStoreRetainer()

    private var viewModelStore = ViewModelStore()

    protected var viewModelProvider = ViewModelProvider(viewModelStore)

    fun onCreate(activityKey: String) {
        if (shouldRetrieveViewModelStore) {
            shouldRetrieveViewModelStore = false
            viewModelStore = globalViewModelStoreRetainer.retrieve(activityKey) ?: ViewModelStore().also { viewModelProvider = ViewModelProvider(viewModelStore) }
            println("ViewModelStore: $viewModelStore")
        }
    }

    fun onDestroy(isFinishing: Boolean, activityKey: String) {
        if (isFinishing) {
            viewModelStore.clear()
        } else {
            println("Storing viewModelStore: $viewModelStore")
            shouldRetrieveViewModelStore = true
            viewModelStore.let { globalViewModelStoreRetainer.retain(activityKey,it) }
        }
    }
}