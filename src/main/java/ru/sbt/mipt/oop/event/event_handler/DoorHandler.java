package ru.sbt.mipt.oop.event.event_handler;


import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.room.Door;
import ru.sbt.mipt.oop.sensor.SensorEvent;
import ru.sbt.mipt.oop.sensor.SensorEventType;

public class DoorHandler implements Handler {

    public void work(SmartHome smartHome, SensorEvent event) {

        if (event.getType() == SensorEventType.DOOR_CLOSED ||
                event.getType() == SensorEventType.DOOR_OPEN) {

            smartHome.execute(object ->
            {
                if (object instanceof Door) {

                    Door door = (Door) object;

                    if (door.getId().equals(event.getObjectId()) &&
                            event.getType() == SensorEventType.DOOR_OPEN) {

                        door.setOpen(true);
                        System.out.println("Door " + door.getId() + " was opened");
                    }

                    if (door.getId().equals(event.getObjectId()) &&
                            event.getType() == SensorEventType.DOOR_CLOSED) {

                        door.setOpen(false);
                        System.out.println("Door " + door.getId() + " was closed");
                    }

                }
            });
        }
    }

}