package ru.sbt.mipt.oop.test.remoteControlTest.functionTest;

import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.HomeState;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.function.CloseHallDoor;
import ru.sbt.mipt.oop.room.Door;
import ru.sbt.mipt.oop.room.Light;
import ru.sbt.mipt.oop.room.Room;

import java.io.IOException;

import static org.junit.Assert.*;

public class CloseHallDoorTest {

    @Test
    public void hallDoorCloseTest() throws IOException {
        HomeState state = new HomeState();
        SmartHome smartHome = state.reload();
        CloseHallDoor closeHallDoor = new CloseHallDoor(smartHome);
        closeHallDoor.execute();
        for (Room room : smartHome.getRooms()) {

            if (room.getName().equals("hall")) {

                for (Door door : room.getDoors()) {
                    Assert.assertFalse(door.isOpen());
                }
            }

            for (Light light : room.getLights()) {
                Assert.assertFalse(light.isOn());
            }
        }
    }

}