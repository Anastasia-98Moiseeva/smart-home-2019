package ru.sbt.mipt.oop;

public interface Actionable {
    void execute(Action action, String message);

    default void runExecution(boolean positiveEvent, String message) {
        throw new UnsupportedOperationException();
    }

}
