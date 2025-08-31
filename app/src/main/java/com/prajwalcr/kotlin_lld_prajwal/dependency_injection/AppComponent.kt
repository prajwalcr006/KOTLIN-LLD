package com.prajwalcr.kotlin_lld_prajwal.dependency_injection

import com.prajwalcr.kotlin_lld_prajwal.dependency_injection.data.DIModule
import com.prajwalcr.kotlin_lld_prajwal.dependency_injection.framework.DIComponent

open class AppComponent: DIComponent() {

    init {
        setupDI()
    }

    private fun setupDI() {
        diContainer.installModule(DIModule())
    }

    override fun inject(target: Any) {
        injectField(target)
    }

}