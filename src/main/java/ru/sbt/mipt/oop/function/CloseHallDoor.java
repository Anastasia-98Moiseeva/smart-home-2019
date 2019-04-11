package ru.sbt.mipt.oop.function;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.room.Door;
import ru.sbt.mipt.oop.room.Light;
import ru.sbt.mipt.oop.room.Room;

public class CloseHallDoor implements Function {

    private SmartHome smartHome;

    public CloseHallDoor(SmartHome smartHome){
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {

        for (Room room : smartHome.getRooms()) {

            if (room.getName().equals("hall")) {

                for (Door door : room.getDoors()) {
                    door.setOpen(false);
                }
            }

            for (Light light : room.getLights()) {
                light.setOn(false);
            }
        }

    }
}
