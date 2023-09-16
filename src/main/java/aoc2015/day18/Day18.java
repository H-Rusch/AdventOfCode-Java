package aoc2015.day18;

import aoc2015.Day2015;

public class Day18 extends Day2015 {

    private static final int STEPS = 100;

    public Day18() {
        super(18);
    }

    @Override
    public Object part1(String input) {
        var lightGrid = new LightGrid(input, false);

        lightGrid.simulation(STEPS);

        return lightGrid.countLitLights();
    }

    @Override
    public Object part2(String input) {
        var lightGrid = new LightGrid(input, true);

        lightGrid.simulation(STEPS);

        return lightGrid.countLitLights();
    }

    public static void main(String[] args) {
        new Day18().main();
    }
}
