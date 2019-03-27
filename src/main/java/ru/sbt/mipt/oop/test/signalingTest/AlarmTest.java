package ru.sbt.mipt.oop.test.signalingTest;


import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.signaling.Alarm;
import ru.sbt.mipt.oop.signaling.Signaling;

public class AlarmTest implements TestSignalState{

    @Test
    public void testChangeState() {
        Signaling signaling = new Signaling("123");
        Alarm alarm = new Alarm(signaling);
        signaling.updateState(alarm);
        alarm.deactivate("123");
        Assert.assertEquals(signaling.isAlarm(), false);
        Assert.assertEquals(signaling.isActive(), false);
    }
}