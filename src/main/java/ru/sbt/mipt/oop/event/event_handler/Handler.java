package ru.sbt.mipt.oop.event.event_handler;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.sensor.SensorEvent;

public interface Handler {
    void work(SmartHome smartHome, SensorEvent event);
}
