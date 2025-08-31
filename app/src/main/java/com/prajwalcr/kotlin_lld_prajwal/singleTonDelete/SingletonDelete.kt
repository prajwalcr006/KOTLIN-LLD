package com.prajwalcr.kotlin_lld_prajwal.singleTonDelete

class SingletonDelete private constructor() {
    companion object {
        private var instance: SingletonDelete? = null
        private val lock = Any()

        fun getInstance(): SingletonDelete {
            synchronized(lock) {
                if (instance == null) {
                    instance = SingletonDelete()
                }
                return instance!!
            }
        }
    }
}


/*
1. Only one instance of this class
2. Constructor should be private
3. Lazy initialization only when requested.
4. static access point for getting instance.
 */