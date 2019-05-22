package ru.sbt.mipt.oop.test.remoteControlTest.functionTest;

import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.HomeState;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.function.TurnOffAllLight;
import ru.sbt.mipt.oop.function.TurnOnAllLight;
import ru.sbt.mipt.oop.room.Light;
import ru.sbt.mipt.oop.room.Room;

import java.io.IOException;

import static org.junit.Assert.*;

public class TurnOnAllLightTest {

    @Test
    public void AllLightTurnOn() throws IOException {
        HomeState state = new HomeState();
        SmartHome smartHome = state.reload();
        TurnOnAllLight turnOnAllLight = new TurnOnAllLight(smartHome);
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                Assert.assertTrue(light.isOn());
            }
        }
    }

}