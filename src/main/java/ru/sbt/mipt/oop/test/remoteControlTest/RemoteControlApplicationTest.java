package ru.sbt.mipt.oop.test.remoteControlTest;

import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.HomeState;
import ru.sbt.mipt.oop.RemoteControlApplication;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.function.ActivateAlarm;
import ru.sbt.mipt.oop.function.Function;

import java.io.IOException;

public class RemoteControlApplicationTest {

    @Test
    public void rcActivateAlarmTest() throws IOException {
        HomeState state = new HomeState();
        SmartHome smartHome = state.reload();
        RemoteControlApplication app = new RemoteControlApplication();
        Function function = new ActivateAlarm(smartHome);
        app.setFunction("A", function);
        app.onButtonPressed("A", "123");
        Assert.assertTrue(smartHome.getSignaling().isAlarm());
    }

}
