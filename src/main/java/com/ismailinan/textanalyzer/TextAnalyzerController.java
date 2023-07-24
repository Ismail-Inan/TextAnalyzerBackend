package com.ismailinan.textanalyzer;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/text_analyzer")
public class TextAnalyzerController {

  @PostMapping("/analyze")
  public ResponseEntity<TextAnalysisResult> analyzeText(
      @RequestBody TextAnalysisRequest request) {
    final String mode = request.getMode();
    final String input = request.getInput();

    if (!StringUtils.hasText(input) || !StringUtils.hasText(mode)) {
      return ResponseEntity.badRequest().body(new TextAnalysisResult());
    }

    if (!("vowels".equalsIgnoreCase(mode) || "consonants".equalsIgnoreCase(mode))) {
      return ResponseEntity.badRequest().body(new TextAnalysisResult());
    }

    final Map<Character, Integer> result = TextAnalyzer.analyze(mode, input);
    final TextAnalysisResult analysisResult = new TextAnalysisResult(result);
    return ResponseEntity.ok(analysisResult);
  }
}