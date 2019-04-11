package ru.sbt.mipt.oop.test.remoteControlTest.functionTest;

import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.HomeState;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.function.TurnOnHallLight;
import ru.sbt.mipt.oop.room.Light;
import ru.sbt.mipt.oop.room.Room;

import java.io.IOException;

import static org.junit.Assert.*;

public class TurnOnHallLightTest {

    @Test
    public void hallLightTurnOn() throws IOException {
        HomeState state = new HomeState();
        SmartHome smartHome = state.reload();
        TurnOnHallLight turnOnHallLight = new TurnOnHallLight(smartHome);
        turnOnHallLight.execute();
        for (Room room : smartHome.getRooms()) {
            if (room.getName().equals("hall")) {
                for (Light light : room.getLights()) {
                    Assert.assertTrue(light.isOn());
                }
            }
        }
    }
}