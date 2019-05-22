package ru.sbt.mipt.oop;

import rc.RemoteControl;
import ru.sbt.mipt.oop.function.Function;

import java.util.HashMap;

public class RemoteControlApplication implements RemoteControl {

    private HashMap<String, Function> functions;

    public RemoteControlApplication(){
        functions = new HashMap<>();
    }

    public void writeFunction(String buttonCode, Function function){
        functions.put(buttonCode, function);
    }

    public boolean checkButtonCode(String buttonCode){
        switch (buttonCode) {
            case "A": return true;
            case "B": return true;
            case "C": return true;
            case "D": return true;
            case "1": return true;
            case "2": return true;
            case "3": return true;
            case "4": return true;
        }
        System.out.println("Wrong button code");
        return false;
    }

    public void setFunction(String buttonCode, Function function){
        if (checkButtonCode(buttonCode) && !functions.containsKey(buttonCode)){
            writeFunction(buttonCode, function);
        }
        if (checkButtonCode(buttonCode) && functions.containsKey(buttonCode)){
            functions.remove(buttonCode);
            writeFunction(buttonCode, function);
        }
    }

    @Override
    public void onButtonPressed(String buttonCode, String rcId) {
        if(functions.containsKey(buttonCode)){
            Function function = functions.get(buttonCode);
            function.execute();
        } else {
            System.out.println("Unable to recognize function");
        }
    }
}
