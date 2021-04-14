package com.healthyryu.alarmtest.utils.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.healthyryu.alarmtest.utils.NotificationHandler
import java.util.*

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
                // 5초 후에 울리도록 설정
//                val triggerTime = (SystemClock.elapsedRealtime() + 5 * 1000)

                // 오후 8시 2분 설정
                val date = Calendar.getInstance().apply {
                    set(Calendar.HOUR_OF_DAY, 20)
                    set(Calendar.MINUTE, 2)
                    set(Calendar.SECOND, 0)
                    set(Calendar.MILLISECOND, 0)
                }

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    // API23 이상부터 도입된 도즈모드에 대한 대처 작업
                    it.setExactAndAllowWhileIdle(
                        AlarmManager.RTC_WAKEUP,
                        date.timeInMillis,
                        pendingIntent
                    )
                } else {
                    it.set(AlarmManager.RTC_WAKEUP, date.timeInMillis, pendingIntent)
                }
            } else {
                it.cancel(pendingIntent)
            }
        }
    }

}