package com.cs.gmu.project321;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by jacob on 11/25/14.
 */
public class TemperatureTest {
  private static Temperature temp = new Temperature();

  @Test
  public void setTempTest() {
    this.temp.set(50);
    //test setting temp value 
    assertEquals(50l, (long)this.temp.get());
  }
}
