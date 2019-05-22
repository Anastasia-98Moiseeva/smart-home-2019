package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.event.event_handler.*;

public class CreatorCompositeHandler {

    public CompositeHandler getCompositeHandler(){
        CompositeHandler compositeHandler = new CompositeHandler();

        Handler eLight = new LightHandler();
        compositeHandler.add(new HandlerDecorator(eLight));

        Handler eDoor = new DoorHandler();
        compositeHandler.add(new HandlerDecorator(eDoor));

        Handler eHall = new HallHandler();
        compositeHandler.add(new HandlerDecorator(eHall));

        return compositeHandler;
    }
}
