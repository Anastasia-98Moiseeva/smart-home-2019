package ru.sbt.mipt.oop.event.event_handler;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.sensor.SensorEvent;
import ru.sbt.mipt.oop.signaling.*;


public class HandlerDecorator implements Handler {

    private Handler wrappee;

    public HandlerDecorator(Handler wrappee) {
        this.wrappee = wrappee;
    }

    public void work(SmartHome smartHome, SensorEvent event) {

        Signaling signaling = smartHome.getSignaling();

        if (signaling.getState() instanceof Activated && event.isSignalingEvent()) {

            signaling = smartHome.getSignaling();
            signaling.updateState(new Alarm(signaling));
            System.out.println("sending sms");

        }

        if (signaling.getState() instanceof Deactivated ||
                (signaling.getState() instanceof Activated && !event.isSignalingEvent())) {

            wrappee.work(smartHome, event);
        }

        if (signaling.getState() instanceof Alarm){

            System.out.println("sending sms");

        }
    }
}
