package aoc2015.day12;

import aoc2015.Day2015;

import java.util.regex.MatchResult;
import java.util.regex.Pattern;

class Day12 extends Day2015 {

    public Day12() {
        super(12);
    }

    @Override
    public Object part1(String input) {
        return Pattern.compile("-?\\d+")
                .matcher(input)
                .results()
                .map(MatchResult::group)
                .mapToInt(Integer::valueOf)
                .sum();
    }

    @Override
    public Object part2(String input) {
        JsonSumNumbers summer = new JsonSumNumbers(input);
        summer.sumWithoutRed();

        return summer.getSum();
    }

    public static void main(String[] args) {
        new Day12().main();
    }
}
