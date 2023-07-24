package com.ismailinan.textanalyzer;

import java.util.HashMap;
import java.util.Map;

public class TextAnalyzer {

  /**
   * Analyzes the input sentence and returns a map containing the count of vowels or consonants,
   * depending on the mode specified.
   *
   * @param mode  The analysis mode - 'vowels' or 'consonants'.
   * @param input The sentence to be analyzed.
   * @return A map containing the count of vowels or consonants.
   */
  public static Map<Character, Integer> analyze(String mode, String input) {
    Map<Character, Integer> characterCount = new HashMap<>();
    char[] chars = input.toUpperCase().toCharArray();

    for (char c : chars) {
      if (mode.equals("vowels") && isVowel(c)) {
        characterCount.put(c, characterCount.getOrDefault(c, 0) + 1);
      } else if (mode.equals("consonants") && isConsonant(c)) {
        characterCount.put(c, characterCount.getOrDefault(c, 0) + 1);
      }
    }

    return characterCount;
  }

  private static boolean isVowel(char c) {
    return "AEIOU".indexOf(c) != -1;
  }

  private static boolean isConsonant(char c) {
    return Character.isLetter(c) && !isVowel(c);
  }
}
