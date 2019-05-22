package ru.sbt.mipt.oop.test;

import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.event.event_handler.LightHandler;
import ru.sbt.mipt.oop.room.Light;
import ru.sbt.mipt.oop.room.Room;
import ru.sbt.mipt.oop.sensor.SensorEvent;
import ru.sbt.mipt.oop.sensor.SensorEventType;

import java.io.IOException;

import static ru.sbt.mipt.oop.sensor.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.sensor.SensorEventType.LIGHT_ON;


public class LightWorkerTest implements ru.sbt.mipt.oop.test.Test {
    @Test
    public void turnOnBedroomLight() throws IOException {
        test("bedroom", "4", LIGHT_ON);
    }

    @Test
    public void turnOffBedroomLight() throws IOException {
        test("bedroom", "4", LIGHT_OFF);
    }

    public void test(String name, String id, SensorEventType type) throws IOException {

        HomeState homeState = new HomeState();
        SmartHome smartHome = homeState.reload();
        SensorEvent event = new SensorEvent(type, id);
        LightHandler lightHandler = new LightHandler();

        for (Room room : smartHome.getRooms()) {

            lightHandler.work(smartHome, event);
            String roomName = room.getName();

            if(roomName.equals(name)) {

                for(Light light: room.getLights()) {

                    String lightId = light.getId();

                    if(lightId.equals(id)) {

                        if (type.equals(LIGHT_OFF)) {
                            Assert.assertFalse(light.isOn());
                        } else {
                            Assert.assertTrue(light.isOn());
                        }
                    }
                }
            }
        }
    }

}