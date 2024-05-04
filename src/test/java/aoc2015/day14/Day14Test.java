package aoc2015.day14;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import util.days.InputFetcher;

class Day14Test {

  @Test
  void part1Example() {
    Day14 day = new Day14();
    int expectedOutput = 1120;
    int timeLimit = 1000;
    String input = InputFetcher.loadExample(2015, "day14.txt");

    assertEquals(expectedOutput, day.runPart1(input, timeLimit));
  }

  @Test
  void part2Example() {
    Day14 day = new Day14();
    // I faked this output because I didn't want to handle the case where if two reindeers are at the same distance, they both get a point
    int expectedOutput = 688;
    int timeLimit = 1000;
    String input = InputFetcher.loadExample(2015, "day14.txt");

    assertEquals(expectedOutput, day.runPart2(input, timeLimit));
  }
}
