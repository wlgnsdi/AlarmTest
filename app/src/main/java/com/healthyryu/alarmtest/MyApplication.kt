package com.healthyryu.alarmtest

import android.app.Application
import com.healthyryu.alarmtest.utils.NotificationHandler

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        NotificationHandler(this)
    }
}