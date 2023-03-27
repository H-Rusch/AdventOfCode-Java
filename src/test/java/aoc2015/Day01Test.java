package aoc2015;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day01Test {

    @Test
    public void part1Test() {
        var day = new Day01();

        assertEquals("0", day.part1("(())"));
        assertEquals("3", day.part1("(()(()("));
        assertEquals("3", day.part1("))((((("));
        assertEquals("-1", day.part1("))("));
        assertEquals("-3", day.part1(")())())"));
    }

    @Test
    public void part2Test() {
        var day = new Day01();

        assertEquals("1", day.part2(")"));
        assertEquals("5", day.part2("()())"));
    }
}