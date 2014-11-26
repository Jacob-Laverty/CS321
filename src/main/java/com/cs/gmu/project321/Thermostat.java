package com.cs.gmu.project321;

/**
 * Created by Hayley on 11/25/2014.
 */
public class Thermostat {

    public Temperature desiredTemp = new Temperature();
    public Temperature currentTemp = new Temperature();

    public static IndoorTempSensor its = new IndoorTempSensor();

    public Thermostat(){
        currentTemp.set(its.currentTemp.get());
    }

    public void setCurrentTemp() {
      this.currentTemp.set(this.its.currentTemp.get());
    }

    void setDesiredTemp(long t){
        desiredTemp.set(t);
    }
}
