package com.healthyryu.alarmtest.utils.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build

class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "android.intent.action.BOOT_COMPLETED") {
            val intentService = Intent(context, AlarmService::class.java).apply {
                putExtra(AlarmService.TITLE, "Alarm")
                putExtra(AlarmService.CONTENT, "Ring Ring .. Ring Ring")
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(intentService)
            } else {
                context.startService(intentService)
            }
        }
    }
}