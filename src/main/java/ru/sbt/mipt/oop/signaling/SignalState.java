package ru.sbt.mipt.oop.signaling;

public abstract class SignalState {

    Signaling signaling;

    SignalState(Signaling signaling) {
        this.signaling = signaling;
    }

    public abstract void changeState(String code);
}
