package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.event.EventProducer;
import ru.sbt.mipt.oop.event.event_handler.*;
import ru.sbt.mipt.oop.sensor.SensorEvent;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {

        EventProducer eventProducer = new EventProducer();

        HomeState state = new HomeState();
        SmartHome smartHome = state.reload();

        CompositeHandler compositeHandler = new CompositeHandler();

        Handler eLight = new LightHandler();
        compositeHandler.add(new HandlerDecorator(eLight));

        Handler eDoor = new DoorHandler();
        compositeHandler.add(new HandlerDecorator(eDoor));

        // начинаем цикл обработки событий
        SensorEvent event = eventProducer.getNextSensorEvent();

        while (event != null) {
            System.out.println("Got event: " + event);
            compositeHandler.work(smartHome, event);
            event = eventProducer.getNextSensorEvent();
        }
    }
}
