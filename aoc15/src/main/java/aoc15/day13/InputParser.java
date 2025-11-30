package aoc15.day13;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import lombok.experimental.UtilityClass;
import util.regex.RegexHelper;

@UtilityClass
class InputParser {

  private static final Pattern PATTERN = Pattern
      .compile("(.*?) would (gain|lose) (\\d+) happiness units by sitting next to (.*?)\\.");

  public static Map<String, Map<String, Integer>> parseInput(String input) {
    Map<String, Map<String, Integer>> result = new HashMap<>();

    for (String line : input.lines().toList()) {
      List<String> groups = RegexHelper.getGroups(PATTERN.matcher(line));

      result.putIfAbsent(groups.get(1), new HashMap<>());
      result.get(groups.get(1))
          .put(groups.get(4), getHappinessChange(groups.get(2), groups.get(3)));
    }

    return result;
  }

  private static Integer getHappinessChange(String changeType, String value) {
    return switch (changeType) {
      case "gain" -> Integer.parseInt(value);
      case "lose" -> -Integer.parseInt(value);
      default -> null;
    };
  }
}
