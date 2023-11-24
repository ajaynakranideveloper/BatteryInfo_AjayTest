package com.example.mylibrary.batteryinfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class BatteryInfoReceiver extends BroadcastReceiver {

    static BatteryInfoListener batteryInfoListener;

    public static BatteryInfoReceiver setBatteryInfoListener(Context context, BatteryInfoListener batteryInfoListener1) {
        batteryInfoListener = batteryInfoListener1;
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        BatteryInfoReceiver batteryInfoReceiver = new BatteryInfoReceiver();
        context.registerReceiver(batteryInfoReceiver, filter);
        return batteryInfoReceiver;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isPresent = intent.getBooleanExtra("present", false);
        String technology = intent.getStringExtra("technology");
        int plugged = intent.getIntExtra("plugged", -1);
        int scale = intent.getIntExtra("scale", -1);
        int health = intent.getIntExtra("health", 0);
        int status = intent.getIntExtra("status", 0);
        int rawlevel = intent.getIntExtra("level", -1);
        int voltage = intent.getIntExtra("voltage", 0);
        int temperature = intent.getIntExtra("temperature", 0);
        int level = 0;
        if (isPresent) {
            if (rawlevel >= 0 && scale > 0) {
                level = rawlevel * 100 / scale;
            }
        }
        if (batteryInfoListener != null) {
            batteryInfoListener.getBatteryLevel(isPresent, technology, plugged, health, status, voltage, temperature, level);
        }
    }
}
