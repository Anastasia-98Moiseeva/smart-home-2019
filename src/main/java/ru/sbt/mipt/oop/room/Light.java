package ru.sbt.mipt.oop.room;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.sensor.SensorEventType;

public class Light{
    private boolean isOn;
    private final String id;

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getId() {
        return id;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public void execute (Action action, String message) {

        if ((action.eventType.equals(SensorEventType.LIGHT_ON) ||
                action.eventType.equals(SensorEventType.LIGHT_OFF)) &&
                (action.objectId.equals(id))) {

            SensorEventType eventType = action.eventType;

            if (eventType == SensorEventType.LIGHT_ON) {
                runExecution(true, message + " was turned on");
            }

            if (eventType == SensorEventType.LIGHT_OFF) {
                runExecution(false, message + " was turned off");
            }
        }
    }


    public void runExecution(boolean positiveEvent, String message){
        this.setOn(positiveEvent);
        System.out.println("Light " + this.getId() + message);
    }

}
