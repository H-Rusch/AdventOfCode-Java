package aoc15.day09;

import static aoc15.InputFetcherKt.loadExample;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day09Test {

  @Test
  void part1() {
    var day = new Day09();
    String input = loadExample("day09.txt");

    assertEquals(605, day.part1(input));
  }

  @Test
  void part2() {
    var day = new Day09();
    String input = loadExample("day09.txt");

    assertEquals(982, day.part2(input));
  }
}