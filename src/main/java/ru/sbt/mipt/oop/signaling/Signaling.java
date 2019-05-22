package ru.sbt.mipt.oop.signaling;

public class Signaling {

    private String code;

    private SignalState state;

    private boolean active;

    private boolean alarm;

    public Signaling() {
        this.code = "123";
        this.state = new Deactivated(this);
        this.active = false;
        this.alarm = false;
    }

    public Signaling(String code) {
        this.code = code;
        this.state = new Deactivated(this);
        this.active = false;
        this.alarm = false;
    }

    private void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setAlarm(boolean alarm){
        this.alarm = alarm;
    }

    public boolean isAlarm() {
        return alarm;
    }

    public SignalState getState() {
        return state;
    }

    public void setState(boolean active, boolean alarm) {
        setAlarm(alarm);
        setActive(active);
    }

    public String getCode() {
        return code;
    }

    public boolean checkCode(String code) {
        return code.equals(this.code);
    }

    public void updateState(SignalState state) {
        this.state = state;
    }

    public void activate(String code) {
        state.activate(code);
    }

    public void deactivate(String code) {
        state.deactivate(code);
    }

    public void alarm() {
        state.alarm();
    }
}
