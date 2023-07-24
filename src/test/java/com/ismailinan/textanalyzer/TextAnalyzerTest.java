package com.ismailinan.textanalyzer;

import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TextAnalyzerTest {

  @Test
  public void testAnalyzeVowelMode_ShouldReturnVowelCount() {
    String input = "Aa Bb C d E";
    Map<Character, Integer> result = TextAnalyzer.analyze("vowels", input);

    Assertions.assertEquals(2, result.size());
    Assertions.assertEquals(2, result.get('A'));
    Assertions.assertEquals(1, result.get('E'));
  }

  @Test
  public void testAnalyzeConsonantMode_ShouldReturnConsonantCount() {
    String input = "Aa Bb C d E";
    Map<Character, Integer> result = TextAnalyzer.analyze("consonants", input);

    Assertions.assertEquals(3, result.size());
    Assertions.assertEquals(2, result.get('B'));
    Assertions.assertEquals(1, result.get('C'));
    Assertions.assertEquals(1, result.get('D'));
  }

  @Test
  public void testAnalyzeEmptyInput_ShouldReturnEmptyMap() {
    Map<Character, Integer> result = TextAnalyzer.analyze("vowels", "");

    Assertions.assertTrue(result.isEmpty());
  }

  @Test
  public void testAnalyzeSpecialCharactersInput_ShouldReturnCorrectCounts() {
    String input = "Aa Bb C d E !?&";
    Map<Character, Integer> result = TextAnalyzer.analyze("consonants", input);

    Assertions.assertEquals(3, result.size());
    Assertions.assertEquals(2, result.get('B'));
    Assertions.assertEquals(1, result.get('C'));
    Assertions.assertEquals(1, result.get('D'));
  }

}
