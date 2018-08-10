package com.leopord.concurrency

import java.util.concurrent.*

class AppScheduledExecutorService : ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors()) {

    companion object {
        private val INSTANCE: AppScheduledExecutorService by lazy { AppScheduledExecutorService() }

        fun getInstance(): AppScheduledExecutorService = INSTANCE
    }



}