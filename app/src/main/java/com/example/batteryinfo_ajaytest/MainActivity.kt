package com.example.batteryinfo_ajaytest

import android.annotation.SuppressLint
import android.os.BatteryManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.batteryinfo_ajaytest.databinding.ActivityMainBinding
import com.example.mylibrary.batteryinfo.BatteryInfoListener
import com.example.mylibrary.batteryinfo.BatteryInfoReceiver
import com.example.mylibrary.batteryinfo.BatteryUtils
import com.example.mylibrary.calculator.SumTwoInt
import kotlin.random.Random


class MainActivity : AppCompatActivity(), BatteryInfoListener {

    private lateinit var batteryInfoReceiver: BatteryInfoReceiver
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Sum of two int with random numbers
        val a = Random.nextInt(1, 3000)
        val b = Random.nextInt(1, 5000)
        binding.sumOfTwoIntTv.text = "Sum of two values $a + $b = " + SumTwoInt().sumTwoValues(a, b)
        batteryInfoReceiver = BatteryInfoReceiver.setBatteryInfoListener(this, this)
    }

    override fun onDestroy() {
        unregisterReceiver(batteryInfoReceiver)
        super.onDestroy()
    }

    private fun setBatteryLevelText(text: String) {
        binding.batteryInfoTv.text = text
    }


    override fun getBatteryLevel(
        isPresent: Boolean,
        technology: String?,
        plugged: Int,
        health: Int,
        status: Int,
        voltage: Int,
        temperature: Int,
        level: Int
    ) {
        if (isPresent) {
            var info = "Battery Level: $level%\n"
            info += "Technology: $technology\n"
            info += "Plugged: ${BatteryUtils().getPlugTypeString(plugged)}\n"
            info += "Health: ${BatteryUtils().getHealthString(health)}\n"
            info += "Status: ${BatteryUtils().getStatusString(status)}\n"
            info += "Voltage: $voltage\n"
            info += "Temperature: $temperature\n\n\n"
            setBatteryLevelText("$info")
        } else {
            setBatteryLevelText("Battery not present!!!")
        }
    }

}