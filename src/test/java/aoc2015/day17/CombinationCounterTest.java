package aoc2015.day17;

import static aoc.InputFetcherKt.loadExample;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CombinationCounterTest {

  @Test
  void part1Example() {
    int limit = 25;
    String input = loadExample(2015, "day17.txt");
    var containers = Day17.parseInput(input);
    var combinationCounter = new CombinationCounter(limit, containers);
    int expectedOutput = 4;

    assertEquals(expectedOutput, combinationCounter.generateCombinations());
  }

  @Test
  void part2Example() {
    int limit = 25;
    String input = loadExample(2015, "day17.txt");
    var containers = Day17.parseInput(input);
    var combinationCounter = new CombinationCounter(limit, containers);
    int expectedOutput = 3;

    combinationCounter.generateCombinations();

    assertEquals(expectedOutput, combinationCounter.differentWaysWithMinContainers());
  }
}
