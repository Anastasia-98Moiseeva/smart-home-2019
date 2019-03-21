package ru.sbt.mipt.oop.test.signalingTest;

import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.signaling.Activated;
import ru.sbt.mipt.oop.signaling.Deactivated;
import ru.sbt.mipt.oop.signaling.Signaling;

public class SignalingTest{

    @Test
    public void testGetCode() {
        Signaling signaling = new Signaling("123");
        Assert.assertEquals(signaling.getCode(), "123");
    }


    @Test
    public void testSetActive() {
        Signaling signaling = new Signaling("123");
        signaling.setActive(true);
        Assert.assertEquals(signaling.isActive(), true);
    }

    @Test
    public void testIsActive() {
        Signaling signaling = new Signaling("123");
        Assert.assertEquals(signaling.isActive(), false);
    }

    @Test
    public void testSetAlarm() {
        Signaling signaling = new Signaling("123");
        signaling.setAlarm(true);
        Assert.assertEquals(signaling.isAlarm(), true);
    }

    @Test
    public void testIsAlarm() {
        Signaling signaling = new Signaling("123");
        Assert.assertEquals(signaling.isAlarm(), false);
    }

    @Test
    public void testCheckCode() {
        Signaling signaling = new Signaling("123");
        Assert.assertEquals(signaling.checkCode("123"), true);
    }

    @Test
    public void testUpdateState() {
        Signaling signaling = new Signaling("123");
        Activated a = new Activated(signaling);
        signaling.updateState(a);
        Assert.assertEquals(signaling.getState(), a);
    }

}