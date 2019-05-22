package ru.sbt.mipt.oop.test;

import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.event.event_handler.DoorHandler;
import ru.sbt.mipt.oop.room.Door;
import ru.sbt.mipt.oop.room.Room;
import ru.sbt.mipt.oop.sensor.SensorEvent;
import ru.sbt.mipt.oop.sensor.SensorEventType;

import java.io.IOException;

import static ru.sbt.mipt.oop.sensor.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.sensor.SensorEventType.DOOR_OPEN;

public class DoorHandlerTest implements ru.sbt.mipt.oop.test.Test {

    @Test
    public void openBedroomDoor() throws IOException {
        test("bedroom", "3", DOOR_OPEN);
    }

    @Test
    public void closeBedroomDoor() throws IOException {
        test("bedroom", "3", DOOR_CLOSED);
    }

    public void test(String name, String id, SensorEventType type) throws IOException {

        HomeState homeState = new HomeState();
        SmartHome smartHome = homeState.reload();
        SensorEvent event = new SensorEvent(type, id);
        DoorHandler doorHandler = new DoorHandler();

        for (Room room : smartHome.getRooms()) {

            doorHandler.work(smartHome, event);
            String roomName = room.getName();

            if(roomName.equals(name)) {

                for(Door door: room.getDoors()) {

                    String doorId = door.getId();

                    if(doorId.equals(id)) {

                        if (type.equals(DOOR_CLOSED)) {
                            Assert.assertFalse(door.isOpen());
                        } else {
                            Assert.assertTrue(door.isOpen());
                        }
                    }
                }
            }
        }
    }

}