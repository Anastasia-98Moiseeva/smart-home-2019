package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;


public class EventWorker {

    Collection<Handler> events;

    EventWorker() {
        events = new ArrayList<>();
    }

    public void add(Handler e){
        events.add(e);
    }

    public void workEvent(SmartHome smartHome, SensorEvent event) {
        for (Room room : smartHome.getRooms()) {
            for (Handler e : events) {
                e.work(smartHome, room, event);
            }
        }
    }
}
