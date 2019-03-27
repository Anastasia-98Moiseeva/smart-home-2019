package ru.sbt.mipt.oop.signaling;

public class Activated extends SignalState {

    public Activated(Signaling signaling){
        super(signaling);
        signaling.setState(true, false);
    }

    @Override
    public void activate(String code) { }

    @Override
    public void deactivate(String code) {
        if (signaling.checkCode(code)) {
            signaling.updateState(new Deactivated(signaling));
        } else {
            alarm();
        }
    }
}
