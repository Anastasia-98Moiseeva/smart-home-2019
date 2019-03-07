package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class EventWorker {

    SensorEvent event;

    EventWorker(SensorEvent event_) {
        event = event_;
    }

    public void work(SmartHome smartHome) {

        System.out.println("Got event: " + event);
        for (Room room : smartHome.getRooms()) {
            if (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF) {

                // событие от источника света
                LightWorker lightWorker = new LightWorker();
                lightWorker.work(room, event);
            }
            if (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED) {

                // событие от двери
                DoorWorker doorWorker = new DoorWorker();
                doorWorker.work(room, event, smartHome);
            }
        }
    }
}
