package ru.sbt.mipt.oop.event.event_handler;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.room.Light;
import ru.sbt.mipt.oop.sensor.SensorEvent;
import ru.sbt.mipt.oop.sensor.SensorEventType;

public class LightHandler implements Handler {

    public void work(SmartHome smartHome, SensorEvent event) {

        if (event.getType() == SensorEventType.LIGHT_OFF ||
                event.getType() == SensorEventType.LIGHT_ON) {

            smartHome.execute(object ->
            {
                if (object instanceof Light){

                    Light light = (Light) object;

                    if(light.getId().equals(event.getObjectId()) &&
                            event.getType() == SensorEventType.LIGHT_ON) {

                        light.setOn(true);
                        System.out.println("Light " + light.getId() + " was turned on");
                    }

                    if(light.getId().equals(event.getObjectId()) &&
                            event.getType() == SensorEventType.LIGHT_OFF) {

                        light.setOn(false);
                        System.out.println("Light " + light.getId() + " was turned off");
                    }

                }
            });
        }
    }

}
