package ru.sbt.mipt.oop.event;

import ru.sbt.mipt.oop.sensor.SensorEvent;

public interface Producer {
    SensorEvent getNextSensorEvent();
}
