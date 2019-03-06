package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Application {

    public static void main(String... args) throws IOException {

        SensorEvent event = getNextSensorEvent();

        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get("smart-home-1.js")));
        SmartHome smartHome = gson.fromJson(json, SmartHome.class);
        System.out.println("Got event: " + event);

        EventWorker eventWorker = new EventWorker(event, smartHome);

        while (event != null) {
            eventWorker.work();
            event = getNextSensorEvent();
        }
    }

    private static SensorEvent getNextSensorEvent() {

        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) {
            return null; // null means end of event stream
        }

        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));

        return new SensorEvent(sensorEventType, objectId);
    }
}
