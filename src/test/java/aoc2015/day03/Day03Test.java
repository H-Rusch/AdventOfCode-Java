package aoc2015.day03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day03Test {

    @Test
    void part1Test() {
        var day = new Day03();

        assertEquals(2, day.part1(">"));
        assertEquals(4, day.part1("^>v<"));
        assertEquals(2, day.part1("^v^v^v^v^v^v"));
    }

    @Test
    void part2Test() {
        var day = new Day03();

        assertEquals(3, day.part2("^v"));
        assertEquals(3, day.part2("^>v<"));
        assertEquals(11, day.part2("^v^v^v^v^v"));
    }
}
