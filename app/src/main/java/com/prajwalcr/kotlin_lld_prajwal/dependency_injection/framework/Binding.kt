package com.prajwalcr.kotlin_lld_prajwal.dependency_injection.framework

data class Binding<T>(
    val type: Class<T>,
    val scope: Scope,
    val provider: () -> T
)
