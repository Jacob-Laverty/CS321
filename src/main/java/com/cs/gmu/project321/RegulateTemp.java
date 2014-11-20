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
        //make fan fan
        if(desiredTemp < currentTemp){
            //regulate heat
        } else {
            //regulate ac
        }

    }



}
