package aoc15.day21;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class FightTest {

  @Test
  void exampleFight() {
    var hero = new Fighter(8, 5, 5);
    var boss = new Fighter(12, 7, 2);

    var result = new Day21().fight(hero, boss);

    assertTrue(result);
  }
}
