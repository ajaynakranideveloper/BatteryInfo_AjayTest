package com.example.mylibrary.batteryinfo

import android.os.BatteryManager

public class BatteryUtils {
    public fun getPlugTypeString(plugged: Int): String? {
        var plugType = "Unknown"
        when (plugged) {
            BatteryManager.BATTERY_PLUGGED_AC -> plugType = "AC"
            BatteryManager.BATTERY_PLUGGED_USB -> plugType = "USB"
        }
        return plugType
    }

    public fun getHealthString(health: Int): String? {
        var healthString = "Unknown"
        when (health) {
            BatteryManager.BATTERY_HEALTH_DEAD -> healthString = "Dead"
            BatteryManager.BATTERY_HEALTH_GOOD -> healthString = "Good"
            BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE -> healthString = "Over Voltage"
            BatteryManager.BATTERY_HEALTH_OVERHEAT -> healthString = "Over Heat"
            BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE -> healthString = "Failure"
        }
        return healthString
    }

    public fun getStatusString(status: Int): String? {
        var statusString = "Unknown"
        when (status) {
            BatteryManager.BATTERY_STATUS_CHARGING -> statusString = "Charging"
            BatteryManager.BATTERY_STATUS_DISCHARGING -> statusString = "Discharging"
            BatteryManager.BATTERY_STATUS_FULL -> statusString = "Full"
            BatteryManager.BATTERY_STATUS_NOT_CHARGING -> statusString = "Not Charging"
        }
        return statusString
    }
}