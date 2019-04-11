package ru.sbt.mipt.oop.room;

import ru.sbt.mipt.oop.Action;

public class Door {
    private final String id;
    private boolean isOpen;

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public String getId() { return id; }

    public boolean isOpen() { return isOpen; }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void execute (Action action) {

        action.execute(this);
    }
}
