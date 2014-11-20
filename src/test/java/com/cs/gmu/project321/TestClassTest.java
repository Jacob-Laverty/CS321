package com.cs.gmu.project321;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by jacob on 11/20/14.
 */
public class TestClassTest {
  private static final String expected = "Hello World";
  private TestClass foo = new TestClass();
  @Test
  public void testPasses() {
    assertEquals(expected, foo.getOutput());
  }

  @Test
  public void testFails(){
    foo.goAwry();
    assertEquals(expected, foo.getOutput());
  }
}
