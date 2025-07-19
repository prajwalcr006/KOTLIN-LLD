package com.prajwalcr.kotlin_lld_prajwal.state

class Log {
    companion object {
        private val logProcessor = InfoLogProcessor(ErrorLogProcessor(DebugLogProcessor()))
        fun i(message: String) {
            logProcessor.processLog(LogProcessor.INFO, message)
        }

        fun d(message: String) {
            logProcessor.processLog(LogProcessor.DEBUG, message)
        }

        fun e(message: String) {
            logProcessor.processLog(LogProcessor.ERROR, message)
        }

        fun w(message: String) {
            logProcessor.processLog(LogProcessor.WARNING, message)
        }
    }
}