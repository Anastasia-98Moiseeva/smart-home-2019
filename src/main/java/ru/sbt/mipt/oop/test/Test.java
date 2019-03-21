package ru.sbt.mipt.oop.test;

import ru.sbt.mipt.oop.sensor.SensorEventType;

import java.io.IOException;

public interface Test {
    void test(String name, String id, SensorEventType type) throws IOException;
}
