package com.prajwalcr.kotlin_lld_prajwal.custom_viewmodel.viewmodel

class ViewModelStore {
    private val viewModelMap: MutableMap<String, CustomViewModel> = mutableMapOf()

    fun getViewModel(tag: String) = viewModelMap[tag]

    fun putViewModel(tag: String, viewModel: CustomViewModel) {
        val oldViewModel = viewModelMap[tag]
        viewModelMap[tag] = viewModel
        oldViewModel?.clear()
    }

    fun clear() {
        viewModelMap.values.forEach { viewModel ->
            viewModel.clear()
        }
    }
}