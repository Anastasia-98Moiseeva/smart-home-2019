package ru.sbt.mipt.oop.sensor;

public class SensorEvent {
    private SensorEventType type;
    private String objectId;

    public SensorEvent(SensorEventType type, String objectId) {
        this.type = type;
        this.objectId = objectId;
    }

    public SensorEvent() {}

    public SensorEventType getType() {
        return type;
    }

    public String getObjectId() {
        return objectId;
    }

    @Override
    public String toString() {
        return "SensorEvent{" +
                "type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }

    public boolean isSignalingEvent(){
        return (type.equals(SensorEventType.ALARM_DEACTIVATE)
                || type.equals(SensorEventType.ALARM_ACTIVATE));
    }
}
