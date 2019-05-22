package ru.sbt.mipt.oop.function;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.signaling.Signaling;

public class ActivateAlarm implements Function {

    private SmartHome smartHome;

    public ActivateAlarm(SmartHome smartHome){
        this.smartHome = smartHome;
    }

    @Override
    public void execute(){
        Signaling signaling = smartHome.getSignaling();
        signaling.alarm();
    }
}
