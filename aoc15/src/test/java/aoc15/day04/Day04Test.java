package aoc15.day04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day04Test {

  @Test
  void part1Test() {
    var day = new Day04();

    assertEquals(254575, day.part1("bgvyzdsv"));
    assertEquals(609043, day.part1("abcdef"));
    assertEquals(1048970, day.part1("pqrstuv"));
  }
}
