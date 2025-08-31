package com.prajwalcr.kotlin_lld_prajwal.dependency_injection

import com.prajwalcr.kotlin_lld_prajwal.dependency_injection.data.UserRepository
import com.prajwalcr.kotlin_lld_prajwal.dependency_injection.framework.Inject

class MainActivity: AppComponent() {

    @Inject
    lateinit var userRepository: UserRepository

    fun injectParameter() {
        inject(this)
    }
}