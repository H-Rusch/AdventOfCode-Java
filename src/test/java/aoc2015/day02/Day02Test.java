package aoc2015.day02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day02Test {

  @Test
  void part1Test() {
    var day = new Day02();

    assertEquals(58, day.part1("2x3x4"));
    assertEquals(43, day.part1("1x1x10"));
  }

  @Test
  void part2Test() {
    var day = new Day02();

    assertEquals(34, day.part2("2x3x4"));
    assertEquals(14, day.part2("1x1x10"));
  }
}
