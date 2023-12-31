package com.ismailinan.textanalyzer;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TextAnalysisResult {

  private Map<Character, Integer> characterCounts;
}