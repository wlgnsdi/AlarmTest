package com.healthyryu.alarmtest.utils.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import com.healthyryu.alarmtest.utils.NotificationHandler

class AlarmHandler constructor(
    private val context: Context
) {
    private var alarmManager: AlarmManager? = null

    init {
        alarmManager = context.getSystemService(Context.ALARM_SERVICE) as? AlarmManager?
    }

    fun setAlarm(isChecked: Boolean) {
        alarmManager?.let {
            val alarmIntent = Intent(context, AlarmReceiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(
                context,
                NotificationHandler.NOTIFICATION_ID,
                alarmIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
            )

            if (isChecked) {
                val triggerTime = (SystemClock.elapsedRealtime() + 5 * 1000)
                it.set(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent)
            } else {
                it.cancel(pendingIntent)
            }
        }
    }

}