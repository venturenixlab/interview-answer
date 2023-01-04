package com.vtxlab.dsa.brackets;

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
    // Time Complexity Test should be within 1 second.
    assertTrue("Time Complexity Fail", elapsedTime < 1.0d);
  }

  @Test
  public void _02_space_complexity() {
    long before = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage()
        .getUsed();
    Solution.generateBrackets(12, bracketCharArray);
    long after = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage()
        .getUsed();
    long heapSizeUsedInMb = (after - before) / 1024 / 1024;
    System.out.println("heapSizeUsedInMb=" + heapSizeUsedInMb);
    // Space Complexity Test should be within 50 MB.
    assertTrue("Space Complexity Fail", heapSizeUsedInMb < 50);
  }

}
