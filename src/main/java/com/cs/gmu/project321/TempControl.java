package com.cs.gmu.project321;

/**
 * Created by Jacob on 11/20/14.
 */
public class TempControl {
    //need dummy classes for all of these objects and for Temperature
    private static AC myAC = new AC();
    private static PriHeat myHeater = new PriHeat();
    private static SecHeat mySecondHeater = new SecHeat();
    private static Fan myFan = new Fan();
    private static Thermostat therm = new Thermostat();

    public String mode;
    private long desired;
    private long current;

    TempControl(String mode){
        this.mode = mode;
        this.desired = therm.desiredTemp.get();
        this.current = therm.currentTemp.get();
        monitorTemp();
    }

    protected HVACDevice HVACDAO(HVACDevice device) {
      if(device instanceof AC) {
       return this.myAC;
      } else if (device instanceof PriHeat) {
        return this.myHeater;
      } else if (device instanceof SecHeat) {
        return this.mySecondHeater;
      } else if (device instanceof Fan) {
        return this.myFan;
      } else {
        return null;
      }

    }

    public void setMode(String mode){
        this.mode = mode;
    }

    public void setDesired(long temp) {
      this.therm.desiredTemp.set(temp);
      this.desired = this.therm.desiredTemp.get();
    }

    public long getCurrent() {
      return this.current;
    }

    public void updateCurrentTemp() {
      this.therm.its.updateRawSensorValue();
      this.therm.its.monitorTemp();
      this.therm.setCurrentTemp();
      this.current = this.therm.currentTemp.get();
    }

    void monitorTemp(){
        myFan.on();

        if(mode.equalsIgnoreCase("AC")) {
            if (desired < current){
                while (desired < current) {
                    myAC.on();
                    current = therm.currentTemp.get();
                    return;
                }
            }
          myAC.off();
        } else if(mode.equalsIgnoreCase("Heat")){
            if(desired < current){
                while (desired < current) {
                    myHeater.on();
                    if(current - desired >= 10){
                        mySecondHeater.on();
                    }
                    current = therm.currentTemp.get();
                  return;
                }
            }
          myHeater.off();
          mySecondHeater.off();


        } else if(mode.equalsIgnoreCase("FanOnly")){

        } else {
            myFan.off();
            return;
        }
    }
}
