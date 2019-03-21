package ru.sbt.mipt.oop.signaling;

public class Activated extends SignalState {

    public Activated(Signaling signaling){
        super(signaling);
        signaling.setActive(true);
        signaling.setAlarm(false);
    }

    @Override
    public void changeState(String code) {
        if (signaling.checkCode(code)) {
            signaling.updateState(new Deactivated(signaling));
        } else {
            signaling.updateState(new Alarm(signaling));
        }
    }
}
