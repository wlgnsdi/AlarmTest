package com.healthyryu.alarmtest.utils.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "android.intent.action.BOOT_COMPLETED") {
            // TODO(새롭게 AndroidOS가 부팅이 된 후에 알람을 설정해야 한다)
        }
    }
}