package com.healthyryu.alarmtest.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.healthyryu.alarmtest.databinding.ActivityMainBinding
import com.healthyryu.alarmtest.utils.alarm.AlarmHandler

class MainActivity : AppCompatActivity() {
    private val alarmHandler: AlarmHandler by lazy { AlarmHandler(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toggleBtn.setOnCheckedChangeListener { _, isChecked ->
            setAlarm(isChecked)
        }
    }

    private fun setAlarm(isChecked: Boolean) {
        alarmHandler.setAlarm(isChecked)
    }
}