package ru.sbt.mipt.oop.signaling;

public abstract class SignalState {

    Signaling signaling;

    SignalState(Signaling signaling) {
        this.signaling = signaling;
    }

    abstract void activate(String code);

    abstract void deactivate(String code);

    public void alarm() {
        signaling.updateState(new Alarm(signaling));
    }
}
