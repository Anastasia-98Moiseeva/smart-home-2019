package ru.sbt.mipt.oop.room;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.event.event_handler.HallHandler;
import ru.sbt.mipt.oop.sensor.SensorEventType;

public class Door {
    private final String id;
    private boolean isOpen;

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public String getId() { return id; }

    public boolean isOpen() { return isOpen; }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void execute (Action action, String message) {
        if (action.objectId.equals(id)) {
            SensorEventType eventType = action.eventType;
            if (eventType == SensorEventType.DOOR_OPEN) {
                runExecution(true, message + " was opened");
            }
            if (eventType == SensorEventType.DOOR_CLOSED) {
                runExecution(false, message + " was closed");

                // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
                // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
                if (message.equals(" in room hall")) {
                    HallHandler hall = new HallHandler();
                    hall.work(action.smartHome, action.event);
                }
            }
        }
    }

    public void runExecution(boolean positiveEvent, String message){
        this.setOpen(positiveEvent);
        System.out.println("Door " + this.getId() + message);
    }

}
