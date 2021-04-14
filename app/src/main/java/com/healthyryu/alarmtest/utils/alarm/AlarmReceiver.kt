package com.healthyryu.alarmtest.utils.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import com.healthyryu.alarmtest.utils.alarm.AlarmService.Companion.CONTENT
import com.healthyryu.alarmtest.utils.alarm.AlarmService.Companion.TITLE

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val intentService = Intent(context, AlarmService::class.java).apply {
            putExtra(TITLE, "Alarm")
            putExtra(CONTENT, "Ring Ring .. Ring Ring")
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(intentService)
        } else {
            context.startService(intentService)
        }
    }
}