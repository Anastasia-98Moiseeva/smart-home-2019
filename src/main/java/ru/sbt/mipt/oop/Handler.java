package ru.sbt.mipt.oop;

public interface Handler {
    public void work(SmartHome smartHome, Room room, SensorEvent event);
}
