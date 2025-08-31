package com.prajwalcr.kotlin_lld_prajwal.dependency_injection.data

class NetworkService() {
    fun fireApi(url: String) {
        println("Got response for $url")
    }
}