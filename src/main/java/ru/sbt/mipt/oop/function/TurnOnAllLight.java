package ru.sbt.mipt.oop.function;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.room.Light;
import ru.sbt.mipt.oop.room.Room;

public class TurnOnAllLight implements Function {
    private SmartHome smartHome;

    public TurnOnAllLight(SmartHome smartHome){
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        for (Room room : smartHome.getRooms()) {

            for (Light light : room.getLights()) {
                light.setOn(true);
            }

        }
    }
}
