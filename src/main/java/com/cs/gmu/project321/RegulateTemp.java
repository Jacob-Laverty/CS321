package com.cs.gmu.project321;

/**
 * Created by Jacob on 11/20/14.
 */
public class TempControl {

    //need dummy classes for all of these objects and for Temperature
    AC myAC = new AC();
    PriHeat myHeater = new PriHeat();
    SecHeat mySecondHeater = new SecHeat();
    Fan myFan = new Fan();
    IndoorTempSensor its = new IndoorTempSensor();

    String mode;
    double desired;
    double current;

    TempControl(String mode, Temperature desiredTemp){
        this.mode = mode;
        desired = desiredTemp.get();
        current = its.currentTemp.get();
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
                    myAC.currentMode = true;
                    current = its.currentTemp.get();
                }
                myAC.off();
                myAC.currentMode = false;
            }

        } else if(mode.equalsIgnoreCase("Heat")){
            if(desired > current){
                while (desired > current) {
                    myHeater.on();
                    myHeater.currentMode = true;
                    if(desired - current >= 10){
                        mySecondHeater.on();
                        mySecondHeater.currentMode = true;
                    }
                    current = its.currentTemp.get();
                }
                myHeater.off();
                myHeater.currentMode = false;
                mySecondHeater.off();
                mySecondHeater.currentMode = false;

            }

        } else if(mode.equalsIgnoreCase("FanOnly")){
            myFan.currentMode = true;
        } else {
            myFan.off();
            return;
        }


    }



}
