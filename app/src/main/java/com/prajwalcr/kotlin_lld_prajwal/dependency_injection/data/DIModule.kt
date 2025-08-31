package com.prajwalcr.kotlin_lld_prajwal.dependency_injection.data

import com.prajwalcr.kotlin_lld_prajwal.dependency_injection.framework.Factory
import com.prajwalcr.kotlin_lld_prajwal.dependency_injection.framework.Module
import com.prajwalcr.kotlin_lld_prajwal.dependency_injection.framework.Provides
import com.prajwalcr.kotlin_lld_prajwal.dependency_injection.framework.SingleTon

@Module
class DIModule {

    @Provides
    @SingleTon
    fun getNetworkService(): NetworkService {
        return NetworkService()
    }

    @Provides
    @SingleTon
    fun getDatabaseService(): DatabaseService {
        return DatabaseService()
    }

    @Provides
    @Factory
    fun getLogger(): Logger {
        return Logger()
    }

    @Provides
    @Factory
    fun getUserRepository(
        networkService: NetworkService,
        databaseService: DatabaseService,
        logger: Logger
    ): UserRepository {
        return UserRepository(networkService, databaseService, logger)
    }
}