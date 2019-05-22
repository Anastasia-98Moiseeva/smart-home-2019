package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.event.EventProducer;

public interface EventsManager {
    void start();
    void setEventProducer(EventProducer eventProducer);
}
