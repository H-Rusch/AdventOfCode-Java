package aoc15.day15;

import static aoc15.InputFetcherKt.loadExample;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day15Test {

  @Test
  void part1Example() {
    Day15 day = new Day15();
    int expectedOutput = 62842880;
    String input = loadExample("day15.txt");

    assertEquals(expectedOutput, day.part1(input));
  }

  @Test
  void part2Example() {
    Day15 day = new Day15();
    int expectedOutput = 57600000;
    String input = loadExample("day15.txt");

    assertEquals(expectedOutput, day.part2(input));
  }
}
