package com.cs.gmu.project321;

/**
 * Created by Jacob on 11/20/14.
 */
public class TempControl {

    Temperature desiredTemp;
    Temperature currentTemp;
    AC myAC;
    PriHeat myHeater;
    SecHeat mySecondHeater;
    Fan myFan;
    String mode;

    void setMode(String mode){
        this.mode = mode;
    }

    void monitorTemp(){

        double dt = desiredTemp.get();
        double ct = currentTemp.get();

        myFan.on();

        if(mode.equalsIgnoreCase("AC")) {
            if (dt < ct) {
                myAC.on();
                myAC.currentMode = true;
                while (dt < ct) {

                }
                myAC.off();
                myAC.currentMode = false;
            }

        } else if(mode.equalsIgnoreCase("Heat")){
            if(dt > ct){
                if(/* myHeater is functional */){
                    myHeater.on();
                    myheater.currentMode = true;
                } else {
                    mySecondHeater.on();
                    mySecondHeater.currentMode = true;
                }
                while (dt > ct) {

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
