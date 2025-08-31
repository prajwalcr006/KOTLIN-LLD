package com.prajwalcr.kotlin_lld_prajwal.custom_viewmodel.viewmodel

class ViewModelProvider(
    private val store: ViewModelStore,
    private val factory: Factory = DefaultFactory()
) {

    interface Factory {
        fun<T: CustomViewModel> create(modelClass: Class<T>): T
    }

    class DefaultFactory: Factory {
        override fun <T : CustomViewModel> create(modelClass: Class<T>): T {
            return try {
                modelClass.getDeclaredConstructor().newInstance()
            } catch (ex: Exception) {
                println("Exception in creating instance of model class: $modelClass!! EX: $ex")
                throw ex
            }
        }
    }

    operator fun<T: CustomViewModel> get(modelClass: Class<T>): T {
        val key = modelClass.canonicalName ?: throw Exception("Cannot Create ViewModel on Anonymous class or Local Class")
        return get("$DEFAULT_KEY:$key", modelClass)
    }

    fun<T: CustomViewModel> get(key: String, modelClass: Class<T>): T {
        var vm = store.getViewModel(key)
        if (modelClass.isInstance(vm)) {
            vm as T
        } else {
            vm?.clear()
        }

        vm = factory.create(modelClass)
        store.putViewModel(key, vm)

        return vm
    }

    companion object {
        private const val DEFAULT_KEY = "com.androidx.lifecycle.viewmodel"
    }
}