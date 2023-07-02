package aoc2015.day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day04Test {

    @Test
    void part1Test() {
        var day = new Day04();

        System.out.println(day.part1("bgvyzdsv"));
        assertEquals(609043, day.part1("abcdef"));
        assertEquals(1048970, day.part1("pqrstuv"));
    }
}
