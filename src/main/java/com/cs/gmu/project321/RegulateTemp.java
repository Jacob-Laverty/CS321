package com.cs.gmu.project321;

/**
 * Created by Jacob on 11/20/14.
 */
public class TempControl {

    //need dummy classes for all of these objects and for Temperature
    static AC myAC = new AC();
    static PriHeat myHeater = new PriHeat();
    static SecHeat mySecondHeater = new SecHeat();
    static Fan myFan = new Fan();
    static Thermostat therm = new Thermostat();

    String mode;
    double desired;
    double current;

    TempControl(String mode){
        this.mode = mode;
        desired = therm.desiredTemp.get();
        current = therm.currentTemp.get();
        monitorTemp();
    }

    void setMode(String mode){
        this.mode = mode;
    }

    void monitorTemp(){

        myFan.on();

        if(mode.equalsIgnoreCase("AC")) {
            if (desired < current){
                while (desired < current) {
                    myAC.on();
                    current = therm.currentTemp.get();
                }
                myAC.off();
            }

        } else if(mode.equalsIgnoreCase("Heat")){
            if(desired > current){
                while (desired > current) {
                    myHeater.on();
                    if(desired - current >= 10){
                        mySecondHeater.on();
                    }
                    current = therm.currentTemp.get();
                }
                myHeater.off();
                mySecondHeater.off();

            }

        } else if(mode.equalsIgnoreCase("FanOnly")){

        } else {
            myFan.off();
            return;
        }


    }



}
