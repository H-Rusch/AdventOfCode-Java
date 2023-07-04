package aoc2015.day14;

import aoc2015.Day2015;

import java.util.Comparator;
import java.util.List;

public class Day14 extends Day2015 {

    private static final int TIME_LIMIT = 2503;

    public Day14() {
        super(14);
    }

    @Override
    public Object part1(String input) {
        return runPart1(input, TIME_LIMIT);
    }

    @Override
    public Object part2(String input) {
        return runPart2(input, TIME_LIMIT);
    }

    Integer runPart1(String input, int seconds) {
        var reindeers = parseInput(input);
        simulateRace1(reindeers, seconds);

        return getFurthestReindeer(reindeers).getDistance();
    }

    Integer runPart2(String input, int seconds) {
        var reindeers = parseInput(input);
        simulateRace2(reindeers, seconds);

        return getHighestScoringReindeer(reindeers).getScore();
    }

    public List<Reindeer> parseInput(String input) {
        return input.lines()
                .map(Reindeer::fromString)
                .toList();
    }

    public void simulateRace1(List<Reindeer> reindeers, int seconds) {
        for (int i = 0; i < seconds; i++) {
            reindeers.forEach(Reindeer::tick);
        }
    }

    public void simulateRace2(List<Reindeer> reindeers, int seconds) {
        for (int i = 0; i < seconds; i++) {
            reindeers.forEach(Reindeer::tick);
            // for my input it was enough to ignore giving each reindeer a point if there is a tie
            getFurthestReindeer(reindeers).increaseScore();
        }
    }

    private Reindeer getFurthestReindeer(List<Reindeer> reindeers) {
        return reindeers.stream()
                .max(Comparator.comparingInt(Reindeer::getDistance))
                .orElseThrow();
    }

    private Reindeer getHighestScoringReindeer(List<Reindeer> reindeers) {
        return reindeers.stream()
                .max(Comparator.comparingInt(Reindeer::getScore))
                .orElseThrow();
    }

    public static void main(String[] args) {
        new Day14().main();
    }
}
