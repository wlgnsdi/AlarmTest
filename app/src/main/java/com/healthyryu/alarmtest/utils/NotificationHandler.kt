package com.healthyryu.alarmtest.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.os.Build

class NotificationHandler constructor(
    context: Context
) {

    companion object {
        const val CHANNEL_ID = "ALARM_SERVICE_CHANNEL"
        const val CHANNEL_NAME = "Alarm Service Channel"
        const val NOTIFICATION_ID = 123
    }

    private var notificationManager: NotificationManager? = null

    init {
        notificationManager =
            context.getSystemService(NOTIFICATION_SERVICE) as? NotificationManager?
        create()
    }

    private fun create() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            )

            notificationManager?.createNotificationChannel(serviceChannel)
        }
    }
}