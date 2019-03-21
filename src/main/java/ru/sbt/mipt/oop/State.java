package ru.sbt.mipt.oop;

import java.io.IOException;

public interface State {
    SmartHome reload() throws IOException;
}
