package ru.sbt.mipt.oop.adapter;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.event.event_handler.Handler;

public class HandlerAdapter implements EventHandler {

    private Handler handler;

    private SmartHome smartHome;

    public HandlerAdapter(SmartHome smartHome, Handler handler) {
        this.handler = handler;
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        handler.work(smartHome, new EventAdapter(event));
    }
}
