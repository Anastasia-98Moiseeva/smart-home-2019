package ru.sbt.mipt.oop.test.remoteControlTest.functionTest;

import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.HomeState;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.function.ActivateAlarm;

import java.io.IOException;


public class ActivateAlarmTest {

    @Test
    public void alarmActivateTest() throws IOException {
        HomeState state = new HomeState();
        SmartHome smartHome = state.reload();
        ActivateAlarm activateAlarm = new ActivateAlarm(smartHome);
        activateAlarm.execute();
        Assert.assertTrue(smartHome.getSignaling().isAlarm());
    }

}