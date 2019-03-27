package ru.sbt.mipt.oop.event.event_handler;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.sensor.SensorEvent;
import ru.sbt.mipt.oop.sensor.SensorEventType;
import ru.sbt.mipt.oop.signaling.Activated;
import ru.sbt.mipt.oop.signaling.Alarm;
import ru.sbt.mipt.oop.signaling.Deactivated;
import ru.sbt.mipt.oop.signaling.Signaling;

public class SignalingHandler implements Handler{

    public void work(SmartHome smartHome, SensorEvent sensorEvent) {
        if (sensorEvent.getType().equals(SensorEventType.ALARM_ACTIVATE)){

            Signaling signaling = smartHome.getSignaling();

            if (!(signaling.getState() instanceof Deactivated)){
                Deactivated deactivated = new Deactivated(signaling);
                deactivated.activate(signaling.getCode());
            }
        }

        if (sensorEvent.getType().equals(SensorEventType.ALARM_DEACTIVATE)){

            Signaling signaling = smartHome.getSignaling();

            if (signaling.getState() instanceof Activated){
                Activated activated = new Activated(signaling);
                activated.deactivate(signaling.getCode());
            }

            if (signaling.getState() instanceof Alarm){
                Alarm alarm = new Alarm(signaling);
                alarm.deactivate(signaling.getCode());
            }
        }
    }
}
