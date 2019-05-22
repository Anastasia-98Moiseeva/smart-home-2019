package ru.sbt.mipt.oop.test.remoteControlTest.functionTest;

import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.HomeState;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.function.ActivateSignaling;

import java.io.IOException;

import static org.junit.Assert.*;

public class ActivateSignalingTest {

    @Test
    public void signalingActivateTest() throws IOException {
        HomeState state = new HomeState();
        SmartHome smartHome = state.reload();
        ActivateSignaling activateSignaling= new ActivateSignaling(smartHome, "123");
        activateSignaling.execute();
        Assert.assertTrue(smartHome.getSignaling().isActive());
    }
}