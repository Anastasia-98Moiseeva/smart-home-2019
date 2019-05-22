package ru.sbt.mipt.oop.function;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.signaling.Signaling;

public class ActivateSignaling implements Function{
    private SmartHome smartHome;
    private String code;

    public ActivateSignaling(SmartHome smartHome, String code) {
        this.smartHome = smartHome;
        this.code = code;
    }

    @Override
    public void execute(){
        Signaling signaling = smartHome.getSignaling();
        signaling.activate(code);
    }
}
