package aoc2015.day08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import util.days.InputFetcher;

class Day08Test {

  @Test
  void stringCharTest() {
    var day = new Day08();

    assertEquals(0, day.stringChars("\"\""));
    assertEquals(3, day.stringChars("\"abc\""));
    assertEquals(7, day.stringChars("\"aaa\\\"aaa\""));
    assertEquals(1, day.stringChars("\"\\x27\""));
    assertEquals(4, day.stringChars("\"\\\\xmy\""));
  }

  @Test
  void codeCharTest() {
    var day = new Day08();

    assertEquals(2, day.codeChars("\"\""));
    assertEquals(5, day.codeChars("\"abc\""));
    assertEquals(10, day.codeChars("\"aaa\\\"aaa\""));
    assertEquals(6, day.codeChars("\"\\x27\""));
    assertEquals(7, day.codeChars("\"\\\\xmy\""));
  }

  @Test
  void encodedStringTest() {
    var day = new Day08();

    assertEquals(6, day.encodedLength("\"\""));
    assertEquals(9, day.encodedLength("\"abc\""));
    assertEquals(16, day.encodedLength("\"aaa\\\"aaa\""));
    assertEquals(11, day.encodedLength("\"\\x27\""));
  }

  @Test
  void part1Test() {
    var day = new Day08();
    String input = InputFetcher.loadExample(2015, 8);

    assertEquals(12, day.part1(input));
  }

  @Test
  void part2Test() {
    var day = new Day08();
    String input = InputFetcher.loadExample(2015, 8);

    assertEquals(19, day.part2(input));
  }
}