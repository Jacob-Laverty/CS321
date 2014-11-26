package com.cs.gmu.project321;

/**
 * Created by Hayley on 11/25/2014.
 */
public class IndoorTempSensor {

  private long rawSensorValue;
  public Temperature currentTemp = new Temperature();

    //need to BS rawSensorValue somehow

    void monitorTemp(){
        currentTemp.set(rawSensorValue);
    }
}
