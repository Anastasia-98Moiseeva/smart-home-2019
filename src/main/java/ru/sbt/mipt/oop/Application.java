package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Application {

    public static void main(String... args) throws IOException {

        EventProducer eventProducer = new EventProducer();

        // считываем состояние дома из файла
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get("smart-home-1.js")));
        SmartHome smartHome = gson.fromJson(json, SmartHome.class);

        // начинаем цикл обработки событий
        SensorEvent event = eventProducer.getNextSensorEvent();

        while (event != null) {
            EventWorker eventWorker = new EventWorker(event);
            eventWorker.work(smartHome);
            event = eventProducer.getNextSensorEvent();
        }
    }
}
