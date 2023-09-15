package aoc2015.day17;

import org.junit.jupiter.api.Test;
import util.days.InputFetcher;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CombinationCounterTest {

    @Test
    void part1Example() {
        int limit = 25;
        String input = InputFetcher.loadExample(2015, 17);
        var containers = Day17.parseInput(input);
        var combinationCounter = new CombinationCounter(limit, containers);
        int expectedOutput = 4;

        assertEquals(expectedOutput, combinationCounter.generateCombinations());
    }

    @Test
    void part2Example() {
        int limit = 25;
        String input = InputFetcher.loadExample(2015, 17);
        var containers = Day17.parseInput(input);
        var combinationCounter = new CombinationCounter(limit, containers);
        int expectedOutput = 3;

        combinationCounter.generateCombinations();

        assertEquals(expectedOutput, combinationCounter.differentWaysWithMinContainers());
    }
}
