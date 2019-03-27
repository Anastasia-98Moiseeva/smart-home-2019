package ru.sbt.mipt.oop.adapter;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.sensor.SensorEvent;
import ru.sbt.mipt.oop.sensor.SensorEventType;

import static ru.sbt.mipt.oop.sensor.SensorEventType.*;

public class EventAdapter extends SensorEvent {

    private CCSensorEvent ccSensorEvent;

    public EventAdapter (CCSensorEvent ccSensorEvent) { this.ccSensorEvent = ccSensorEvent;}

    @Override
    public SensorEventType getType() {
        switch (ccSensorEvent.getEventType()) {

            case "LightIsOn":
                return LIGHT_ON;

            case "LightIsOff":
                return LIGHT_OFF;

            case "DoorIsOpen":
                return DOOR_OPEN;

            case "DoorIsClosed":
                return DOOR_CLOSED;

            case "DoorIsLocked":
                return DOOR_LOCKED;

            case "DoorIsUnlocked":
                return DOOR_UNLOCKED;
        }
        return null;
    }

    @Override
    public String getObjectId() {
        return ccSensorEvent.getObjectId();
    }

}
