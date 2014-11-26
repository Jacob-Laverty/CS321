package com.cs.gmu.project321;

/**
 * Created by Hayley on 11/25/2014.
 */
public class Thermostat {

    public Temperature desiredTemp;
    public Temperature currentTemp;

    static IndoorTempSensor its = new IndoorTempSensor();

    Thermostat(){
        currentTemp.set(its.currentTemp.get());
    }

    void setDesiredTemp(double t){
        desiredTemp.set(t);
    }
}
