package ru.sbt.mipt.oop.event.event_handler;


import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.sensor.SensorEvent;

public class DoorHandler implements Handler {

    public void work(SmartHome smartHome, SensorEvent event) {
        Action action = new Action(smartHome, event);
        smartHome.execute(action, " in room ");
    }
}

