package aoc2015.day21;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FightTest {

    @Test
    void exampleFight() {
        var hero = new Fighter(8, 5, 5);
        var boss = new Fighter(12, 7, 2);

        var result = new Day21().fight(hero, boss);

        assertTrue(result);
    }
}
