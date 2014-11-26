package com.cs.gmu.project321;

import org.junit.Test;

import java.util.Random;
import java.lang.reflect.*;

import static org.junit.Assert.*;

/**
 * Created by jacob on 11/25/14.
 */
public class TempControlTest {
  private TempControl tempControl = new TempControl("AC");
  private static final int MAX = 75;
  private static final int MIN = 65;

  @Test
  public void testMode() {
    assertEquals("AC", tempControl.mode);
    tempControl.setMode("Heat");
    assertEquals("Heat", tempControl.mode);
    tempControl.setMode("FanOnly");
    assertEquals("FanOnly", tempControl.mode);
  }

  @Test
  public void testTempAC() {
    tempControl.setMode("AC");
    tempControl.updateCurrentTemp();
    long currentTemp = tempControl.getCurrent();

    //Set desired to be less that currentTemp
    long desired = currentTemp + 1;
    tempControl.setDesired(desired);
    HVACDevice d  = tempControl.HVACDAO(new AC());

    tempControl.monitorTemp();
    assertEquals(false, d.currentMode);

    desired = currentTemp - 1;
    tempControl.setDesired(desired);

    tempControl.monitorTemp();
    assertEquals(true, d.currentMode);
  }

  @Test
  public void testTempHeat() {
    tempControl.setMode("Heat");
    tempControl.updateCurrentTemp();

    long currentTemp = tempControl.getCurrent();
    long desired = currentTemp - 1;

    tempControl.setDesired(desired);
    HVACDevice d = tempControl.HVACDAO(new PriHeat());

    tempControl.monitorTemp();
    assertEquals(true, d.currentMode);

    desired = currentTemp + 1;
    tempControl.setDesired(desired);

    tempControl.monitorTemp();
    assertEquals(false, d.currentMode);

    desired = currentTemp - 11;
    d = tempControl.HVACDAO(new SecHeat());
    tempControl.setDesired(desired);
    tempControl.monitorTemp();

    assertEquals(true, d.currentMode);
  }
}
