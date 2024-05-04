package aoc2015.day13;

import aoc2015.AbstractDay2015;
import java.util.HashMap;
import java.util.Map;
import lombok.NonNull;

public class Day13 extends AbstractDay2015 {

  public Day13() {
    super(13);
  }

  @NonNull
  @Override
  public Object part1(@NonNull String input) {
    var potentialHappiness = InputParser.parseInput(input);

    return new HappinessCalculator(potentialHappiness).calculateMaxHappiness();
  }

  @NonNull
  @Override
  public Object part2(@NonNull String input) {
    var potentialHappiness = InputParser.parseInput(input);
    addYouToMap(potentialHappiness);

    return new HappinessCalculator(potentialHappiness).calculateMaxHappiness();
  }

  private void addYouToMap(Map<String, Map<String, Integer>> potentialHappiness) {
    String you = "You";
    potentialHappiness.put(you, new HashMap<>());
    for (String name : potentialHappiness.keySet()) {
      potentialHappiness.get(name).put(you, 0);
      potentialHappiness.get(you).put(name, 0);
    }
  }

  public static void main(String[] args) {
    new Day13().executeParts();
  }
}
