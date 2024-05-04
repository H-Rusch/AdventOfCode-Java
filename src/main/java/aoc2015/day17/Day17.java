package aoc2015.day17;

import aoc2015.AbstractDay2015;
import java.util.Comparator;
import java.util.List;
import lombok.NonNull;

public class Day17 extends AbstractDay2015 {

  private static final int LIMIT = 150;

  public Day17() {
    super(17);
  }

  @NonNull
  @Override
  public Object part1(@NonNull String input) {
    var containers = parseInput(input);
    var combinationCounter = new CombinationCounter(LIMIT, containers);

    return combinationCounter.generateCombinations();
  }

  @NonNull
  @Override
  public Object part2(@NonNull String input) {
    var containers = parseInput(input);
    var combinationCounter = new CombinationCounter(LIMIT, containers);

    combinationCounter.generateCombinations();

    return combinationCounter.differentWaysWithMinContainers();
  }

  public static List<Integer> parseInput(String input) {
    return input.lines()
        .map(Integer::parseInt)
        .sorted(Comparator.reverseOrder())
        .toList();
  }

  public static void main(String[] args) {
    new Day17().executeParts();
  }
}
