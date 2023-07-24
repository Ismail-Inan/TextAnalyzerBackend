package com.ismailinan.textanalyzer;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(TextAnalyzerController.class)
public class TextAnalyzerControllerTest {

  private static final String ANALYZE_URL = "/api/text_analyzer/analyze";

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testAnalyzeTextWithVowels() throws Exception {
    String input = "Test1@ Aa";
    String mode = "vowels";

    mockMvc.perform(post(ANALYZE_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"mode\": \"" + mode + "\", \"input\": \"" + input + "\"}"))
        .andExpect(status().isOk())
        .andExpect(content().json("{\"characterCounts\": {\"A\": 2, \"E\": 1}}"));

  }

  @Test
  public void testAnalyzeTextWithConsonants() throws Exception {
    String input = "Test1@ Aa";
    String mode = "consonants";

    mockMvc.perform(post(ANALYZE_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"mode\": \"" + mode + "\", \"input\": \"" + input + "\"}"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json("{\"characterCounts\": {\"T\": 2, \"S\": 1}}"));
  }

  @Test
  public void testAnalyzeTextWithEmptyInput() throws Exception {
    mockMvc.perform(post(ANALYZE_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"mode\": \"vowels\", \"input\": \"\"}"))
        .andExpect(status().isBadRequest())
        .andExpect(content().json("{}"));
  }

  @Test
  public void testAnalyzeTextWithInvalidMode() throws Exception {
    mockMvc.perform(post(ANALYZE_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"mode\": \"invalid\", \"input\": \"Hello, World!\"}"))
        .andExpect(status().isBadRequest());
  }
}