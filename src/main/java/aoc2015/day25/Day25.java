package aoc2015.day25;

import aoc2015.Day2015;
import util.grid.Point;

import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Day25 extends Day2015 {

    public Day25() {
        super(25);
    }

    @Override
    public Object part1(String input) {
        var point = parseInput(input);
        var codeGenerator = new CodeGenerator();

        return codeGenerator.calculateAt(point);
    }

    @Override
    public Object part2(String input) {
        return "No puzzle :)";
    }

    private Point parseInput(String input) {
        var matcher = Pattern.compile("\\d+").matcher(input);
        var numbers = matcher.results().map(MatchResult::group).toArray(String[]::new);

        return new Point(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
    }

    public static void main(String[] args) {
        new Day25().main();
    }
}
