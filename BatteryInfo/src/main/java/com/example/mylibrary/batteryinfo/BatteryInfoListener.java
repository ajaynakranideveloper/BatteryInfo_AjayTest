package com.example.mylibrary.batteryinfo;

public interface BatteryInfoListener {

    public void getBatteryLevel(boolean isPresent, String technology, int plugged, int health,
                                int status, int voltage, int temperature, int level);
}
