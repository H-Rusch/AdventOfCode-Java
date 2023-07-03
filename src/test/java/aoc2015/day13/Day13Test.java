package aoc2015.day13;

import org.junit.jupiter.api.Test;
import util.days.InputFetcher;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day13Test {

    @Test
    void part1() {
        var day = new Day13();
        String input = InputFetcher.loadExample(2015, 13);

        assertEquals(330, day.part1(input));
    }
}
