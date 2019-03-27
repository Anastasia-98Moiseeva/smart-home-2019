package ru.sbt.mipt.oop.test.signalingTest;

import org.junit.Assert;
import org.junit.Test;

import ru.sbt.mipt.oop.signaling.Activated;
import ru.sbt.mipt.oop.signaling.Signaling;

public class ActivatedTest implements TestSignalState{

    @Test
    public void testChangeState() {
        Signaling signaling = new Signaling("123");
        Activated activated = new Activated(signaling);
        activated.deactivate("123");
        Assert.assertEquals(signaling.isAlarm(), false);
        Assert.assertEquals(signaling.isActive(), false);
    }

}