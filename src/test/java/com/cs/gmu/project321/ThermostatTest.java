package com.cs.gmu.project321;

import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by jacob on 11/25/14.
 */
public class ThermostatTest {
  private static Thermostat thermostat = new Thermostat();
  private static final int MAX = 75;
  private static final int MIN = 65;
  Random random = new Random();

  @Test
  public void ThermostatTest() {
    long rawValue = random.nextInt(MAX - MIN + 1) + MIN;
    try {
      Field f = IndoorTempSensor.class.getDeclaredField("rawSensorValue");
      f.setAccessible(true);
      f.setLong(this.thermostat.its, rawValue);
    } catch (NoSuchFieldException e) {
      System.err.println(e.getMessage());
    } catch(IllegalAccessException e) {
      System.err.println(e.getMessage());
    }

    //Assert its curr value is the therm surr temp
    this.thermostat.its.monitorTemp();
    assertEquals(this.thermostat.currentTemp.get(), this.thermostat.currentTemp.get());

    //Assert desired is desired
    this.thermostat.setDesiredTemp(65l);
    assertEquals(65l, this.thermostat.desiredTemp.get());
  }
}
