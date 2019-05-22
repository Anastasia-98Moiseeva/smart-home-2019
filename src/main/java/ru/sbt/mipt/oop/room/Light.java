package ru.sbt.mipt.oop.room;

import ru.sbt.mipt.oop.Action;

public class Light{
    private boolean isOn;
    private final String id;

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getId() {
        return id;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public void execute (Action action/*, String message*/) {
        action.execute(this);
    }

}
