package aoc2015.day17;

import aoc2015.Day2015;

import java.util.Comparator;
import java.util.List;

public class Day17 extends Day2015 {

    private static final int LIMIT = 150;

    public Day17() {
        super(17);
    }

    @Override
    public Object part1(String input) {
        var containers = parseInput(input);
        var combinationCounter = new CombinationCounter(LIMIT, containers);

        return combinationCounter.generateCombinations();
    }

    @Override
    public Object part2(String input) {
        return null;
    }

    public static void main(String[] args) {
        new Day17().main();
    }

    public static List<Integer> parseInput(String input) {
        return input.lines()
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .toList();
    }
}
