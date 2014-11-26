package com.cs.gmu.project321;

import java.util.Random;

/**
 * Created by Hayley on 11/25/2014.
 */
public class IndoorTempSensor {

  private long rawSensorValue;
  public Temperature currentTemp = new Temperature();

  public IndoorTempSensor() {
    Random random = new Random();
    this.rawSensorValue = random.nextInt(75-65 + 1) + 65;
  }

  public void updateRawSensorValue() {
    Random random = new Random();
    this.rawSensorValue = random.nextInt(75-65 + 1) + 65;
  }

    //need to BS rawSensorValue somehow

    void monitorTemp(){
        currentTemp.set(rawSensorValue);
    }
}
