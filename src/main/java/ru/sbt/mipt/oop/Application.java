package ru.sbt.mipt.oop;

import com.google.gson.Gson;
import org.w3c.dom.events.Event;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Application {

    public static void main(String... args) throws IOException {

        EventProducer eventProducer = new EventProducer();

        HomeState state = new HomeState();
        SmartHome smartHome = state.count();

        EventWorker eventWorker = new EventWorker();

        Handler eLight = new LightWorker();
        eventWorker.add(eLight);

        Handler eDoor = new DoorWorker();
        eventWorker.add(eDoor);

        // начинаем цикл обработки событий
        SensorEvent event = eventProducer.getNextSensorEvent();

        while (event != null) {

            System.out.println("Got event: " + event);
            eventWorker.workEvent(smartHome, event);
            event = eventProducer.getNextSensorEvent();
        }
    }
}
