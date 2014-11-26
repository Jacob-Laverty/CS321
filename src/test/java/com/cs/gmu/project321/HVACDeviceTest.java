package com.cs.gmu.project321;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

/**
 * Created by jacob on 11/25/14.
 */

public class HVACDeviceTest {
  protected static final Map<String, HVACDevice> devices;
  protected static final Map<String, Long> addrMap;

  static {
    Map<String, HVACDevice> dMap = new HashMap<String, HVACDevice>();
    Map<String, Long> map = new HashMap<String, Long>();
    dMap.put("AC", new AC());
    dMap.put("Fan", new Fan());
    dMap.put("PriHeat", new PriHeat());
    dMap.put("SecHeat", new SecHeat());

    map.put("AC", 39843l);
    map.put("Fan", 83594l);
    map.put("PriHeat", 12345l);
    map.put("SecHeat", 67890l);

    devices = Collections.unmodifiableMap(dMap);
    addrMap = Collections.unmodifiableMap(map);
  }

  private static HVACDevice device;

  private void loadDevice(String d) {
    this.device = this.devices.get(d);
  }

  private long getPhysicalAddress() {
    long addr  = this.device.physicalAddress;
    return addr;
  }

  private void turnDeviceOn() {
    this.device.on();
  }

  private void turnDeviceOff() {
    this.device.off();
  }

  private boolean getDeviceStatus() {
    return device.currentMode;
  }

  @Test
  public void ACTest() {
    loadDevice("AC");

    long expected = this.addrMap.get("AC");
    long actual = getPhysicalAddress();

    assertEquals(expected, actual);
    this.turnDeviceOn();
    assertEquals(true, this.getDeviceStatus());

    this.turnDeviceOff();
    assertEquals(false, this.getDeviceStatus());
  }

  @Test
  public void FanTest() {
    loadDevice("Fan");
    long expected = this.addrMap.get("Fan");
    long actual = getPhysicalAddress();

    assertEquals(actual, expected);
    this.turnDeviceOn();
    assertEquals(true, this.getDeviceStatus());

    this.turnDeviceOff();
    assertEquals(false, this.getDeviceStatus());
  }

  @Test
  public void PriHeatTest() {
    loadDevice("PriHeat");

    long expected = this.addrMap.get("PriHeat");
    long actual = getPhysicalAddress();

    assertEquals(actual, expected);
    this.turnDeviceOn();
    assertEquals(true, this.getDeviceStatus());

    this.turnDeviceOff();
    assertEquals(false, this.getDeviceStatus());
  }

  @Test
  public void SecHeatTest() {
    loadDevice("SecHeat");

    long expected = this.addrMap.get("SecHeat");
    long actual = getPhysicalAddress();

    assertEquals(actual, expected);
    this.turnDeviceOn();
    assertEquals(true, this.getDeviceStatus());

    this.turnDeviceOff();
    assertEquals(false, this.getDeviceStatus());
  }


}
