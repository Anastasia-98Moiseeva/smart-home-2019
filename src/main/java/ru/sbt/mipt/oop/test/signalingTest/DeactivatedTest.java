package ru.sbt.mipt.oop.test.signalingTest;

import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.signaling.Deactivated;
import ru.sbt.mipt.oop.signaling.Signaling;

public class DeactivatedTest implements TestSignalState{

    @Test
    public void testChangeState() {
        Signaling signaling = new Signaling("123");
        Deactivated deactivated = new Deactivated(signaling);
        signaling.updateState(deactivated);
        deactivated.changeState("222");
        Assert.assertEquals(signaling.isAlarm(), true);
        Assert.assertEquals(signaling.isActive(), true);
    }

}