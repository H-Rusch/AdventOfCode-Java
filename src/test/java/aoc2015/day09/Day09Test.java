package aoc2015.day09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import util.days.InputFetcher;

class Day09Test {

  @Test
  void part1() {
    var day = new Day09();
    String input = InputFetcher.loadExample(2015, "day09.txt");

    assertEquals(605, day.part1(input));
  }

  @Test
  void part2() {
    var day = new Day09();
    String input = InputFetcher.loadExample(2015, "day09.txt");

    assertEquals(982, day.part2(input));
  }
}