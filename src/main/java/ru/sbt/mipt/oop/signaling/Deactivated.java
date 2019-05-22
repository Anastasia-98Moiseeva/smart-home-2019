package ru.sbt.mipt.oop.signaling;

public class Deactivated extends SignalState {

    public Deactivated(Signaling signaling){
        super(signaling);
        signaling.setState(false, false);
    }

    @Override
    public void deactivate(String code) {}

    @Override
    public void activate(String code) {
        if (signaling.checkCode(code)) {
            signaling.updateState(new Activated(signaling));
        } else {
            alarm();
        }
    }
}
