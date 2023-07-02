package aoc2015;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day06Test {

    @Test
    void part1Test() {
        var day = new Day06();

        assertEquals(1000000, day.part1("turn on 0,0 through 999,999"));
        assertEquals(999000, day.part1("toggle 0,0 through 999,0"));
        assertEquals(998996, day.part1("turn off 499,499 through 500,500"));
    }

    @Test
    void part2Test() {
        var day = new Day06();

        assertEquals(1, day.part2("turn on 0,0 through 0,0"));
        assertEquals(2000001, day.part2("toggle 0,0 through 999,999"));
    }
}
