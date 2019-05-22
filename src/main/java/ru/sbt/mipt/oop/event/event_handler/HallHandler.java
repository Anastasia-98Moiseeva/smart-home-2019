package ru.sbt.mipt.oop.event.event_handler;

import ru.sbt.mipt.oop.room.Door;
import ru.sbt.mipt.oop.sensor.CommandType;
import ru.sbt.mipt.oop.room.Light;
import ru.sbt.mipt.oop.room.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.sensor.SensorCommand;
import ru.sbt.mipt.oop.sensor.SensorEvent;
import ru.sbt.mipt.oop.sensor.SensorEventType;

public class HallHandler implements Handler{

    public void work(SmartHome smartHome, SensorEvent event) {

        for (Room room : smartHome.getRooms()) {

            for (Door door : room.getDoors()) {

                SensorEventType type = event.getType();
                String roomName = room.getName();

                if (type.equals(SensorEventType.DOOR_CLOSED) &&
                        roomName.equals("hall") &&
                        event.getObjectId().equals(door.getId())) {

                    turnOffLight(smartHome);
                }
            }
        }

    }

    private void turnOffLight(SmartHome smartHome){
        for (Room homeRoom : smartHome.getRooms()) {
            for (Light light : homeRoom.getLights()) {
                light.setOn(false);
                SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                sendCommand(command);
            }
        }
    }

    private static void sendCommand(SensorCommand command) {
        System.out.println("Present we're sending command " + command);
    }

}
