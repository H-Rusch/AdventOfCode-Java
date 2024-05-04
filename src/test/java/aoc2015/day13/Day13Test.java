package aoc2015.day13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import util.days.InputFetcher;

class Day13Test {

  @Test
  void part1() {
    var day = new Day13();
    String input = InputFetcher.loadExample(2015, "day13.txt");

    assertEquals(330, day.part1(input));
  }
}
