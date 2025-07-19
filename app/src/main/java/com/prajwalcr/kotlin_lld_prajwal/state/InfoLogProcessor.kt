package com.prajwalcr.kotlin_lld_prajwal.state

class InfoLogProcessor(
    nextProcessor: LogProcessor? = null
): LogProcessor(nextProcessor) {
    override fun processLog(loggerLevel: Int, message: String) {
        if (loggerLevel == INFO) {
            println("INFO: $message")
            return
        }
        super.processLog(loggerLevel, message)
    }
}