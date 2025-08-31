package com.prajwalcr.kotlin_lld_prajwal.dependency_injection

import com.prajwalcr.kotlin_lld_prajwal.dependency_injection.data.Logger
import com.prajwalcr.kotlin_lld_prajwal.dependency_injection.data.NetworkService

fun main() {
    val appComponent = AppComponent()

    val networkService1 = appComponent.diContainer.getInstance(NetworkService::class.java)
    val networkService2 = appComponent.diContainer.getInstance(NetworkService::class.java)

    println("Is network service1: $networkService1 and network service2: $networkService2 same = ${networkService1 === networkService2}")

    val logger1 = appComponent.diContainer.getInstance(Logger::class.java)
    val logger2 = appComponent.diContainer.getInstance(Logger::class.java)

    println("Is network service1: $logger1 and network service2: $logger2 same = ${logger1 === logger2}")

    val mainActivity = MainActivity()

    mainActivity.injectParameter()

    mainActivity.userRepository.performApiCall("https://google.com")
}