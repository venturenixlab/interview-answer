package com.vtxlab.dsa.brackets;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class SampleUnitTest {

  private static final char[] bracketCharArray = new char[] { '(', ')' };

  @Test
  public void _01_generate_zero_bracket() {
    List<String> results = Solution.generateBrackets(0, bracketCharArray);
    assertNotNull(results);
    assertEquals(0, results.size());
  }

  @Test
  public void _02_generate_one_bracket() {
    List<String> results = Solution.generateBrackets(1, bracketCharArray);
    List<String> answers = Arrays.asList("()");
    assertNotNull(results);
    assertEquals(results.size(), 1);
    assertTrue(results.containsAll(answers));
  }

  @Test
  public void _03_generate_two_brackets() {
    List<String> results = Solution.generateBrackets(2, bracketCharArray);
    List<String> answers = Arrays.asList("()()", "(())");
    assertNotNull(results);
    assertEquals(results.size(), 2);
    assertTrue(results.containsAll(answers));
  }

  @Test
  public void _03_generate_three_brackets() {
    List<String> results = Solution.generateBrackets(3, bracketCharArray);
    List<String> answers = Arrays.asList("()()()", "(()())", "((()))", "()(())",
        "(())()");
    assertNotNull(results);
    assertEquals(results.size(), 5);
    assertTrue(results.containsAll(answers));
  }

  @Test
  public void _04_generate_four_brackets() {
    List<String> results = Solution.generateBrackets(4, bracketCharArray);
    assertNotNull(results);
    assertEquals(results.size(), 14);
  }

  @Test
  public void _05_generate_five_brackets() {
    List<String> results = Solution.generateBrackets(5, bracketCharArray);
    assertNotNull(results);
    assertEquals(results.size(), 42);
  }

  @Test
  public void _06_generate_six_brackets() {
    List<String> results = Solution.generateBrackets(6, bracketCharArray);
    assertNotNull(results);
    assertEquals(results.size(), 132);
  }

  @Test
  public void _07_generate_seven_brackets() {
    List<String> results = Solution.generateBrackets(7, bracketCharArray);
    assertNotNull(results);
    assertEquals(results.size(), 429);
  }

  @Test
  public void _08_generate_eight_brackets() {
    List<String> results = Solution.generateBrackets(8, bracketCharArray);
    assertNotNull(results);
    assertEquals(results.size(), 1430);
  }

  @Test
  public void _09_generate_nine_brackets() {
    List<String> results = Solution.generateBrackets(9, bracketCharArray);
    assertNotNull(results);
    assertEquals(results.size(), 4862);
  }

  @Test
  public void _10_generate_ten_brackets() {
    List<String> results = Solution.generateBrackets(10, bracketCharArray);
    assertNotNull(results);
    assertEquals(results.size(), 16796);
  }

  @Test
  public void _11_generate_eleven_brackets() {
    List<String> results = Solution.generateBrackets(11, bracketCharArray);
    assertNotNull(results);
    assertEquals(results.size(), 58786);
  }

  @Test
  public void _12_generate_twelve_brackets() {
    List<String> results = Solution.generateBrackets(12, bracketCharArray);
    assertNotNull(results);
    assertEquals(results.size(), 208012);
  }

}
