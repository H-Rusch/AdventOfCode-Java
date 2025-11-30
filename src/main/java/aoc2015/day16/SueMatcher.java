package aoc2015.day16;

import java.util.Map;

public class SueMatcher {

  private final Sue example;

  public SueMatcher(Sue example) {
    this.example = example;
  }

  public boolean matchesExactly(Sue sue) {
    return sue.getFields().entrySet()
        .stream()
        .allMatch(this::entryMatchesExampleExactly);
  }

  private boolean entryMatchesExampleExactly(Map.Entry<String, Integer> entry) {
    return example.getFields().get(entry.getKey()).equals(entry.getValue());
  }

  public boolean matchesWithRanges(Sue sue) {
    return sue.getFields().entrySet()
        .stream()
        .allMatch(this::entryMatchesExampleWithRanges);
  }

  private boolean entryMatchesExampleWithRanges(Map.Entry<String, Integer> entry) {
    String key = entry.getKey();
    Integer value = entry.getValue();

    return switch (key) {
      case "trees", "cats" -> value > example.getFields().get(key);
      case "pomeranians", "goldfish" -> value < example.getFields().get(key);
      default -> example.getFields().get(key).equals(value);
    };
  }
}
