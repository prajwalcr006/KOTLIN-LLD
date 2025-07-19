package com.prajwalcr.kotlin_lld_prajwal.state

class ErrorLogProcessor(
    nextProcessor: LogProcessor? = null
): LogProcessor(nextProcessor) {
    override fun processLog(loggerLevel: Int, message: String) {
        if (loggerLevel == ERROR) {
            println("ERROR: $message")
            return
        }
        super.processLog(loggerLevel, message)
    }
}