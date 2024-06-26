package aoc2015.day07;

import static aoc.InputFetcherKt.loadExample;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day07Test {

  @Test
  void buildTreeTest() {
    var day = new Day07();
    String exampleInput = loadExample(2015, "day07.txt");

    day.buildTree(exampleInput);

    assertEquals(72, day.calculateValueForNode("d"));
    assertEquals(507, day.calculateValueForNode("e"));
    assertEquals(492, day.calculateValueForNode("f"));
    assertEquals(114, day.calculateValueForNode("g"));
    assertEquals(65412, day.calculateValueForNode("h"));
    assertEquals(65079, day.calculateValueForNode("i"));
    assertEquals(123, day.calculateValueForNode("x"));
    assertEquals(456, day.calculateValueForNode("y"));
  }
}
