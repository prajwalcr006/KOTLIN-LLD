package com.prajwalcr.kotlin_lld_prajwal.state

abstract class LogProcessor(
    private val nextProcessor: LogProcessor? = null
) {
    companion object {
        const val INFO = 1
        const val ERROR = 2
        const val WARNING = 4
        const val DEBUG = 3
    }

    open fun processLog(loggerLevel: Int, message: String) {
        nextProcessor?.processLog(loggerLevel, message) ?: println("No Logger Found")
    }
}