package ru.sbt.mipt.oop.event.event_handler;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.sensor.SensorEvent;

public class LightHandler implements Handler {

    public void work(SmartHome smartHome, SensorEvent event) {
        Action action = new Action(smartHome, event);
        smartHome.execute(action, " in room ");
    }

}
