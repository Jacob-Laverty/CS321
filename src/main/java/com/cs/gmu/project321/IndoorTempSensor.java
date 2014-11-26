package com.cs.gmu.project321;

/**
 * Created by Hayley on 11/25/2014.
 */
public class IndoorTempSensor {

    private Long rawSensorValue;
    public Temperature currentTemp;

    //need to BS rawSensorValue somehow

    void monitorTemp(){
        currentTemp.set(rawSensorValue);
    }
}
