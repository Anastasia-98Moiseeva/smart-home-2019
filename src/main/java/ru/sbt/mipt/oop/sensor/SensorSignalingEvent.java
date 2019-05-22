package ru.sbt.mipt.oop.sensor;

public class SensorSignalingEvent extends SensorEvent{

    private String code;

    public SensorSignalingEvent(String code, SensorEventType type) {
        super(type, "-1");
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
