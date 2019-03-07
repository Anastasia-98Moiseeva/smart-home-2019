package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightWorker {

    public static void work(Room room, SensorEvent event) {
        // событие от источника света
        for (Light light : room.getLights()) {

            if (light.getId().equals(event.getObjectId())) {

                if (event.getType() == LIGHT_ON) {
                    printEvrnt(true, " was turned on.", light, room);

                } else {
                    printEvrnt(false, " was turned off.", light, room);
                }
            }
        }
    }

    private static void printEvrnt(boolean positivEvent, String message, Light light, Room room) {
        light.setOn(positivEvent);
        System.out.println("Light " + light.getId() + " in room " + room.getName() + message);
    }
}
