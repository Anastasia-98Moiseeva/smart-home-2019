package ru.sbt.mipt.oop.signaling;

public class Alarm extends SignalState {

   public Alarm(Signaling signaling){
       super(signaling);
       signaling.setState(true, true);
   }

    @Override
    public void activate(String code) {}

    @Override
    public void deactivate(String code) {
        if (signaling.checkCode(code)) {
            signaling.updateState(new Deactivated(signaling));
        } else {
            alarm();
        }
    }
}
