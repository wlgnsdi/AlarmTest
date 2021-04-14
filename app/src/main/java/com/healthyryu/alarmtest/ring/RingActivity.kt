package com.healthyryu.alarmtest.ring

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.healthyryu.alarmtest.utils.alarm.AlarmService
import com.healthyryu.alarmtest.databinding.ActivityRingBinding

class RingActivity : AppCompatActivity() {
    lateinit var binding: ActivityRingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnDismiss.setOnClickListener {
                // 알람 해제
                val intentService = Intent(applicationContext, AlarmService::class.java)
                applicationContext.stopService(intentService)
                finish()
            }
        }
    }
}