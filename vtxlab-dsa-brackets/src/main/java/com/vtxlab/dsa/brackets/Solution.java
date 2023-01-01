package com.vtxlab.dsa.brackets;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Generate valid combination of [,],(,), given input parameter n, where 1 < n < 9
// 
public class Solution {

  static final char[] bracketCharArray = new char[] { '(', ')' };

  // Approach 2
  public static boolean isBalance(String s) {
    int openCounter = 0;
    int closeCounter = 0;
    for (char c : s.toCharArray()) {
      if (c == '(')
        openCounter++;
      if (c == ')')
        closeCounter++;
    }
    return openCounter == closeCounter;
  }

  // Approach 1
  public static boolean isValid(String s) {

    Stack<Character> input = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char next = s.charAt(i);
      switch (next) {
        case ')' -> {
          if (input.isEmpty() || input.pop() != '(')
            return false;
        }
        default -> input.push(next);
      }
    }
    return input.empty(); // Revise it to return true, when approach 2
  }

  public static List<String> concatNextChar(List<String> strings,
      char[] bracketArray) {
    List<String> newStrings = new ArrayList<>();
    for (int i = 0; i < bracketArray.length; i++) {
      if (strings.size() == 0) {
        newStrings.add("" + bracketArray[i]);
      }
      for (String str : strings) {
        newStrings.add(str + bracketArray[i]);
      }
    }
    return newStrings;
  }

  public static List<String> generateAllStrings(int n, char[] brackets) {
    List<String> strings = new ArrayList<>();
    for (int i = 0; i < n * 2; i++) { // loop n*2 times
      strings = concatNextChar(strings, brackets);
    }
    return strings;
  }

  public static List<String> generateParenthesis(int n, char[] brackets) {
    List<String> allStrings = generateAllStrings(n, brackets);
    List<String> finalStrings = new ArrayList<>();
    for (String str : allStrings) {
      if (isValid(str))
        finalStrings.add(str);
    }
    return finalStrings;
  }

  // Approach 2

  // Recursive
  public static void concatString(Integer n, List<String> list, String str,
      char[] brackets) {

    if (isValid(str)) {
      if (str.length() == n * 2) {
        // System.out.println(str.charAt(str.length() - 1));
        if (isBalance(str)) {
          list.add(str);
        }
        return;
      }
      // recursive
      for (int i = 0; i < brackets.length; i++) {
        concatString(n, list, str + brackets[i], brackets);
      }
    }
  }

  public static List<String> generateValidBrackets(int n, char[] brackets) {
    List<String> strings = new ArrayList<>();
    concatString(n, strings, new String(), brackets);
    return strings;
  }

  public static void main(String[] args) {
    LocalDateTime startDateTime = LocalDateTime.now();
    System.out.println(generateParenthesis(8, bracketCharArray).size());
    System.out.println(generateValidBrackets(8, bracketCharArray).size());
    LocalDateTime endDateTime = LocalDateTime.now();
    System.out.println(Duration.between(startDateTime, endDateTime).getNano());
  }
}

// method: given 2 array[] char, output -> 1 List, which has an element
// duplicated 3 times, sort by ascii
// ->