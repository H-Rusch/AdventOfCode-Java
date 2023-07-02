package aoc2015.day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day01Test {

    @Test
    void part1Test() {
        var day = new Day01();

        assertEquals(0, day.part1("(())"));
        assertEquals(3, day.part1("(()(()("));
        assertEquals(3, day.part1("))((((("));
        assertEquals(-1, day.part1("))("));
        assertEquals(-3, day.part1(")())())"));
    }

    @Test
    void part2Test() {
        var day = new Day01();

        assertEquals(1, day.part2(")"));
        assertEquals(5, day.part2("()())"));
    }
}