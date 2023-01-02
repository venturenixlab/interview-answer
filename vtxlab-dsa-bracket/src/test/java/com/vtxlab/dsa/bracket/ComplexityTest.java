package com.vtxlab.dsa.bracket;

import static junit.framework.TestCase.assertTrue;

import java.lang.management.ManagementFactory;

import org.junit.Test;

public class ComplexityTest {

  private static final char[] bracketCharArray = new char[] { '(', ')' };

  @Test
  public void _01_time_complexity() {
    long start = System.nanoTime();
    Solution.generateBrackets(12, bracketCharArray);
    long end = System.nanoTime();
    double elapsedTime = (double) (end - start) / 1_000_000_000;
    assertTrue("Time Complexity Fail", elapsedTime < 1.0d);
  }

  @Test
  public void _02_space_complexity() {
    long before = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage()
        .getUsed();
    Solution.generateBrackets(12, bracketCharArray);
    long after = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage()
        .getUsed();
    long heapSizeUsed = after - before;
    System.out.println(heapSizeUsed / 1024 / 1024);
    assertTrue("Space Complexity Fail", heapSizeUsed < 300);
  }

}
