package ru.sbt.mipt.oop;

public class EventWorker {

    private static SmartHome smartHome;

    EventWorker(SmartHome smartHome_){
        smartHome = smartHome_;
    }

    public void work(SensorEvent event) {

        for (Room room : smartHome.getRooms()) {

            boolean lightEvent = false;
            boolean positiveEvent = false;
            String message;

            switch (event.getType()) {

                case LIGHT_ON:
                    lightEvent = true;
                    positiveEvent = true;
                    message = " was turned on.";
                    recognizeEvent(lightEvent, positiveEvent, message, room, event);
                    break;

                case LIGHT_OFF:
                    lightEvent = true;
                    message = " was turned off.";
                    recognizeEvent(lightEvent, positiveEvent, message, room, event);
                    break;

                case DOOR_OPEN:
                    positiveEvent = true;
                    message = " was opened.";
                    recognizeEvent(lightEvent, positiveEvent, message, room, event);
                    break;

                case DOOR_CLOSED:
                    message =" was closed.";
                    recognizeEvent(lightEvent, positiveEvent, message, room, event);
                    break;
            }
        }
    }

    private static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }

    private void recognizeEvent(boolean lightEvent, boolean positiveEvent,
                                String message, Room room, SensorEvent event){

        if (lightEvent){
            workForLight(positiveEvent, message, room, event);

        } else {
            workForDoor(positiveEvent, message, room, event);
        }
    }

    private void workForLight(boolean positiveEvent, String message, Room room, SensorEvent event){

        for (Light light : room.getLights()) {

            if (light.getId().equals(event.getObjectId())) {
                light.setOn(positiveEvent);
                System.out.println("Light " + light.getId() + " in room " + room.getName() + message);
            }
        }
    }

    private void workForDoor(boolean positiveEvent, String message, Room room, SensorEvent event){

        for (Door door : room.getDoors()) {

            if (door.getId().equals(event.getObjectId())) {
                door.setOpen(positiveEvent);
                System.out.println("Door " + door.getId() + " in room " + room.getName() + message);
            }

            if (!positiveEvent) {
                workForHall(room);
            }
        }
    }

    private static void workForHall(Room room){
        // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
        // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
        if (room.getName().equals("hall")) {

            for (Room homeRoom : smartHome.getRooms()) {

                for (Light light : homeRoom.getLights()) {
                    light.setOn(false);
                    SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                    sendCommand(command);
                }
            }
        }

    }

}
