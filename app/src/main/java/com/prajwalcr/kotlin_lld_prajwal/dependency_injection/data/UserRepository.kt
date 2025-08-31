package com.prajwalcr.kotlin_lld_prajwal.dependency_injection.data

class UserRepository(
    private val networkService: NetworkService,
    private val databaseService: DatabaseService,
    private val logger: Logger
) {
    fun performApiCall(url: String) {
        networkService.fireApi(url)
        databaseService.storeItem()
        logger.log("Fired API and stored in db")
    }
}