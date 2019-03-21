package ru.sbt.mipt.oop.room;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Actionable;
import ru.sbt.mipt.oop.sensor.SensorEventType;

import java.util.Collection;

public class Room implements Actionable {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }

    public void execute (Action action, String message) {
        if (action.eventType.equals(SensorEventType.DOOR_OPEN) ||
                action.eventType.equals(SensorEventType.DOOR_CLOSED)) {
            for (Door door : doors) {
                door.execute(action, message);
            }
        }
        if (action.eventType.equals(SensorEventType.LIGHT_ON) ||
                    action.eventType.equals(SensorEventType.LIGHT_OFF)) {
            for (Light light : lights) {
                light.execute(action, message);
            }
        }
    }
}
