package aoc2015.day24;

import aoc2015.Day2015;

import java.util.List;

public class Day24 extends Day2015 {

    public Day24() {
        super(24);
    }

    @Override
    public Object part1(String input) {
        var presentBalancer = new PresentBalancer(parseInput(input), 3);

        return presentBalancer.findFirstGroupsEntanglement();
    }

    @Override
    public Object part2(String input) {
        var presentBalancer = new PresentBalancer(parseInput(input), 4);

        return presentBalancer.findFirstGroupsEntanglement();
    }

    private List<Integer> parseInput(String input) {
        return input.lines().map(Integer::parseInt).toList();
    }

    public static void main(String[] args) {
        new Day24().main();
    }
}
