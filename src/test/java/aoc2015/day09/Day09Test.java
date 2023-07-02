package aoc2015.day09;

import org.junit.jupiter.api.Test;
import util.days.InputFetcher;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day09Test {

    @Test
    void part1() {
        var day = new Day09();
        String input = InputFetcher.loadExample(2015, 9);

        assertEquals(605, day.part1(input));
    }

    @Test
    void part2() {
        var day = new Day09();
        String input = InputFetcher.loadExample(2015, 9);

        assertEquals(982, day.part2(input));
    }
}