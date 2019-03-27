package ru.sbt.mipt.oop.event.event_handler;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.sensor.SensorEvent;

import java.util.ArrayList;
import java.util.Collection;


public class CompositeHandler implements Handler {

    Collection<Handler> events;

    public CompositeHandler() {
        events = new ArrayList<>();
    }

    public void add(Handler e){
        events.add(e);
    }

    public void work(SmartHome smartHome, SensorEvent event) {
        for (Handler e : events) {
            e.work(smartHome, event);
        }

    }
}
