package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorWorker {
    public static void work(Room room, SensorEvent event, SmartHome smartHome) {

        for (Door door : room.getDoors()) {

            if (door.getId().equals(event.getObjectId())) {

                if (event.getType() == DOOR_OPEN) {
                    printEvrnt(true, " was opened.", door, room);

                } else {
                    printEvrnt(false, " was closed.", door, room);
                    compareWithHall(room, smartHome);
                }
            }
        }
    }

    private static void printEvrnt(boolean positivEvent, String message, Door door, Room room) {
        door.setOpen(positivEvent);
        System.out.println("Door " + door.getId() + " in room " + room.getName() + message);
    }

    private static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }

    private static void compareWithHall(Room room, SmartHome smartHome) {
        // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
        // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
        if (room.getName().equals("hall")) {

            for (Room homeRoom : smartHome.getRooms()) {

                for (Light light : homeRoom.getLights()) {
                    light.setOn(false);
                    SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                    sendCommand(command);
                }
            }
        }

    }
}
