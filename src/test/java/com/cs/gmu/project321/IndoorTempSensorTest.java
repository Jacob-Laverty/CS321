package com.cs.gmu.project321;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Random;
import java.lang.reflect.*;

/**
 * Created by jacob on 11/25/14.
 */
public class IndoorTempSensorTest {

  private static IndoorTempSensor indoorTempSensor =  new IndoorTempSensor();
  Random random = new Random();
  private static final int MAX = 75;
  private static final int MIN = 60;
  @Test
  public void setCurrentTempTest() {
    long rawValue = random.nextInt(MAX - MIN + 1) + MIN;

    try {
      Field f = IndoorTempSensor.class.getDeclaredField("rawSensorValue");
      f.setAccessible(true);
      f.setLong(this.indoorTempSensor, rawValue);
    } catch (NoSuchFieldException e) {
      System.err.println(e.getMessage());
    } catch(IllegalAccessException e) {
      System.err.println(e.getMessage());
    }
    //checks that monitor temp correctly sets currentTemp based on raw value from sensor
    this.indoorTempSensor.monitorTemp();
    assertEquals(indoorTempSensor.currentTemp.get(), rawValue);
  }
}
