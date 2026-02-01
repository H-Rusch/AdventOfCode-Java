package aoc15.day07;

import static aoc.InputFetcherKt.loadExample;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

class Day07Test {

  @Test
  void buildTreeTest() {
    var day = new Day07();
    String exampleInput = loadExample("day07.txt");

    day.buildTree(exampleInput);

    assertAll(
        () -> assertThat(day.calculateValueForNode("d")).isEqualTo(72),
        () -> assertThat(day.calculateValueForNode("e")).isEqualTo(507),
        () -> assertThat(day.calculateValueForNode("f")).isEqualTo(492),
        () -> assertThat(day.calculateValueForNode("g")).isEqualTo(114),
        () -> assertThat(day.calculateValueForNode("h")).isEqualTo(65412),
        () -> assertThat(day.calculateValueForNode("i")).isEqualTo(65079),
        () -> assertThat(day.calculateValueForNode("x")).isEqualTo(123),
        () -> assertThat(day.calculateValueForNode("y")).isEqualTo(456)
    );
  }
}
