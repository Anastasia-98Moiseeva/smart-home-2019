package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.sensor.SensorEvent;
import ru.sbt.mipt.oop.sensor.SensorEventType;

public class Action{

    public SensorEvent event;

    public String objectId;

    public SensorEventType eventType;

    public SmartHome smartHome;

    public Action(SmartHome smartHome_, SensorEvent event_){
        eventType = event_.getType();
        objectId = event_.getObjectId();
        smartHome = smartHome_;
        event = event_;
    }
}
