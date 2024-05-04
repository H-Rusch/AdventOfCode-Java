package aoc2015.day15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import util.days.InputFetcher;

class Day15Test {

  @Test
  void part1Example() {
    Day15 day = new Day15();
    int expectedOutput = 62842880;
    String input = InputFetcher.loadExample(2015, "day15.txt");

    assertEquals(expectedOutput, day.part1(input));
  }

  @Test
  void part2Example() {
    Day15 day = new Day15();
    int expectedOutput = 57600000;
    String input = InputFetcher.loadExample(2015, "day15.txt");

    assertEquals(expectedOutput, day.part2(input));
  }
}
