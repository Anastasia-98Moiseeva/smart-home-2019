package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.event.EventProducer;
import ru.sbt.mipt.oop.event.event_handler.*;
import ru.sbt.mipt.oop.sensor.SensorEvent;

public class MyManager implements EventsManager{

    EventProducer myEventProducer;
    SmartHome smartHome;

    public MyManager(SmartHome smartHome){
        this.smartHome = smartHome;
    }

    @Override
    public void setEventProducer(EventProducer eventProducer){
        myEventProducer = eventProducer;
    }

    @Override
    public void start(){
        CreatorCompositeHandler creatorCompositeHandler = new CreatorCompositeHandler();
        CompositeHandler compositeHandler = creatorCompositeHandler.getCompositeHandler();

        // начинаем цикл обработки событий
        SensorEvent event = myEventProducer.getNextSensorEvent();

        while (event != null) {
            System.out.println("Got event: " + event);
            compositeHandler.work(smartHome, event);
            event = myEventProducer.getNextSensorEvent();
        }

    }


}
