package com.prajwalcr.kotlin_lld_prajwal.state

class DebugLogProcessor(
    nextProcessor: LogProcessor? = null
): LogProcessor(nextProcessor) {
    override fun processLog(loggerLevel: Int, message: String) {
        if (loggerLevel == DEBUG) {
            println("DEBUG: $message")
            return
        }
        super.processLog(loggerLevel, message)
    }
}