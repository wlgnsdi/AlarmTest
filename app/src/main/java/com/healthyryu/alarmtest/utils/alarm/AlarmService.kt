package com.healthyryu.alarmtest.utils.alarm

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.Vibrator
import androidx.core.app.NotificationCompat
import com.healthyryu.alarmtest.R
import com.healthyryu.alarmtest.ring.RingActivity
import com.healthyryu.alarmtest.utils.NotificationHandler.Companion.CHANNEL_ID

class AlarmService : Service() {

    companion object {
        const val TITLE = "title"
        const val CONTENT = "content"
    }

    private var vibrator: Vibrator? = null

    override fun onCreate() {
        super.onCreate()
        vibrator = getSystemService(VIBRATOR_SERVICE) as? Vibrator?
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val alarmTitle = intent.getStringExtra(TITLE)
        val alarmContent = intent.getStringExtra(CONTENT)

        val notificationIntent = Intent(this, RingActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            notificationIntent,
            PendingIntent.FLAG_UPDATE_CURRENT // 페이지를 하나만 유지
        )
        val notification = NotificationCompat.Builder(this, CHANNEL_ID).apply {
            setContentTitle(alarmTitle)
            setContentText(alarmContent)
            setSmallIcon(R.drawable.folder)
            priority = NotificationCompat.PRIORITY_HIGH
            setContentIntent(pendingIntent)
            setFullScreenIntent(pendingIntent, true)
        }


        // Vibrator 동작
        val vibrator = getSystemService(VIBRATOR_SERVICE) as? Vibrator
        val vibratePattern = longArrayOf(100, 100, 1000)
        vibrator?.vibrate(vibratePattern, 0)

        val build = notification.build()
        startForeground(1, build)
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        vibrator?.cancel()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}