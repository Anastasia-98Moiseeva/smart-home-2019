package ru.sbt.mipt.oop.signaling;

public class Deactivated extends SignalState {

    public Deactivated(Signaling signaling){
        super(signaling);
        signaling.setActive(false);
        signaling.setAlarm(false);
    }

    @Override
    public void changeState(String code) {
        if (signaling.checkCode(code)) {
            signaling.updateState(new Activated(signaling));
        } else {
            signaling.updateState(new Alarm(signaling));
        }
    }
}
