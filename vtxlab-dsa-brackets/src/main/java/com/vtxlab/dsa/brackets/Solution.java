package com.vtxlab.dsa.brackets;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Question:
// Generate all valid combinations of "(" and ")",
// given input parameter n, where 0 <= n <= 12
//
// Commands:
// mvn clean install
// mvn test
// mvn test -Dtest="SampleUnitTest"
public class Solution {

  public static List<String> generateBrackets(int n, char[] brackets) {
    List<String> ans = new ArrayList<>();
    generateCombination(n, brackets, "", ans);
    return ans;
  }

  public static boolean isValid(String str) {
    Stack<Character> checker = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == ')') { // ')'
        if (checker.empty() || checker.pop() != '(') {
          return false;
        }
      } else {
        checker.push(str.charAt(i));
      }
    }
    return true;
    // checker.empty() when use approach 1(generate all combinations)
  }

  public static boolean isBalanced(String str) {
    int openCount = 0;
    int closeCount = 0;
    for (int i = 0; i < str.length(); i++) {
      switch (str.charAt(i)) {
        case '(' -> openCount++;
        case ')' -> closeCount++;
      }
    }
    return openCount == closeCount;
  }

  public static void generateCombination(int n, char[] brackets, String str, List<String> combinations) {
    if (n == 0)
      return;
    if (isValid(str)) {
      if (str.length() == n * 2) {
        if (isBalanced(str)) {
          combinations.add(str);
        }
        return;
      }
      for (char bracket : brackets) {
        generateCombination(n, brackets, str + bracket, combinations);
      }
    }
  }

}
