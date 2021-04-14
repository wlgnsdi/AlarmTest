package com.healthyryu.alarmtest.main

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.healthyryu.alarmtest.R
import com.healthyryu.alarmtest.databinding.ActivityMainBinding
import com.healthyryu.alarmtest.utils.NotificationHandler.Companion.CHANNEL_ID
import com.healthyryu.alarmtest.utils.NotificationHandler.Companion.CHANNEL_ID2
import com.healthyryu.alarmtest.utils.NotificationHandler.Companion.NOTIFICATION_ID2
import com.healthyryu.alarmtest.utils.alarm.AlarmHandler

class MainActivity : AppCompatActivity() {
    private val alarmHandler: AlarmHandler by lazy { AlarmHandler(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toggleBtn.setOnCheckedChangeListener { _, isChecked ->
            setAlarm(isChecked)
//            notification()
        }
    }

    private fun setAlarm(isChecked: Boolean) {
        alarmHandler.setAlarm(isChecked)
    }

    private fun notification() {
        createNotificationChannel()
        var builder = NotificationCompat.Builder(this, CHANNEL_ID2)
            .setSmallIcon(R.drawable.folder)
            .setContentTitle("Title")
            .setContentText("text")
            .setStyle(NotificationCompat.BigTextStyle().bigText("Big"))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)) {
            notify(NOTIFICATION_ID2, builder.build())
        }
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Channel_name2"
            val descriptionText = "description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID2, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

}