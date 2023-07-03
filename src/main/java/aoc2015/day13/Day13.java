package aoc2015.day13;

import aoc2015.Day2015;

import java.util.HashMap;
import java.util.Map;

public class Day13 extends Day2015 {

    public Day13() {
        super(13);
    }

    @Override
    public Object part1(String input) {
        var potentialHappiness = InputParser.parseInput(input);

        return new HappinessCalculator(potentialHappiness).calculateMaxHappiness();
    }

    @Override
    public Object part2(String input) {
        var potentialHappiness = InputParser.parseInput(input);
        addYouToMap(potentialHappiness);

        return new HappinessCalculator(potentialHappiness).calculateMaxHappiness();
    }

    private void addYouToMap(Map<String, Map<String, Integer>> potentialHappiness) {
        String you = "You";
        potentialHappiness.put(you, new HashMap<>());
        for (String name : potentialHappiness.keySet()) {
            potentialHappiness.get(name).put(you, 0);
            potentialHappiness.get(you).put(name, 0);
        }
    }

    public static void main(String[] args) {
        new Day13().main();
    }
}
