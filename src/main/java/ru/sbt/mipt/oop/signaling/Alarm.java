package ru.sbt.mipt.oop.signaling;

public class Alarm extends SignalState {

   public Alarm(Signaling signaling){
       super(signaling);
       signaling.setActive(true);
       signaling.setAlarm(true);
   }
    @Override
    public void changeState(String code) {
        if (signaling.checkCode(code)) {
            signaling.updateState(new Deactivated(signaling));
        } else {
            signaling.updateState(new Alarm(signaling));
        }
    }
}
