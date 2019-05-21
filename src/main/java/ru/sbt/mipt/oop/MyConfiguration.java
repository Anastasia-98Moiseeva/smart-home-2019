package ru.sbt.mipt.oop;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import ru.sbt.mipt.oop.event.EventProducer;
import ru.sbt.mipt.oop.event.event_handler.*;
import ru.sbt.mipt.oop.sensor.SensorEvent;

import java.io.IOException;

@Configuration
public class MyConfiguration {

    private SmartHome smartHome;
    private EventsManager eventsManager;

    public MyConfiguration() throws IOException {
        EventProducer eventProducer = new EventProducer();
        HomeState state = new HomeState();
        SmartHome smartHome = state.reload();
        this.smartHome = smartHome;

        eventsManager = new MyManager(smartHome);
        eventsManager.setEventProducer(eventProducer);
    }

    @Bean
    @Description("smarthome")
    SmartHome getSmartHome() {
        return smartHome;
    }

    @Bean
    @Description("eventsManager")
    EventsManager getEventsManager() {
        return eventsManager;
    }
}
