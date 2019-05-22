package ru.sbt.mipt.oop.test;

import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.event.event_handler.HallHandler;
import ru.sbt.mipt.oop.room.Light;
import ru.sbt.mipt.oop.room.Room;
import ru.sbt.mipt.oop.sensor.SensorEvent;
import ru.sbt.mipt.oop.sensor.SensorEventType;

import java.io.IOException;

import static ru.sbt.mipt.oop.sensor.SensorEventType.DOOR_CLOSED;

public class HallHandlerTest implements ru.sbt.mipt.oop.test.Test {

    @Test
    public void closeHallDoor() throws IOException {
       test("hall", "4", DOOR_CLOSED);
    }

    public void test(String name, String id, SensorEventType type) throws IOException {

        HomeState homeState = new HomeState();
        SmartHome smartHome = homeState.reload();
        SensorEvent event = new SensorEvent(type, id);
        HallHandler hall = new HallHandler();

        for (Room room : smartHome.getRooms()) {

            hall.work(smartHome, event);
            String roomName = room.getName();

            if(roomName.equals(name) && type.equals(DOOR_CLOSED)) {

                for(Light light: room.getLights()) {
                    Assert.assertFalse(light.isOn());
                }
            }
        }
    }

}