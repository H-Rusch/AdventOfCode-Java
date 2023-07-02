package aoc2015;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Day06 extends Day {

    private static final int SIZE = 1000;
    // for part 1
    private final boolean[][] grid = new boolean[SIZE][SIZE];
    // for part 2
    private final int[][] lights = new int[SIZE][SIZE];

    private final Pattern pattern = Pattern.compile("^(turn on|turn off|toggle) (\\d+),(\\d+) through (\\d+),(\\d+)$");

    Day06() {
        super(6);
    }

    @Override
    public Integer part1(String input) {
        input.lines().forEach(line -> executeCommand(line, true));

        return countLightsOn();
    }

    @Override
    public Integer part2(String input) {
        input.lines().forEach(line -> executeCommand(line, false));

        return calculateTotalLights();
    }

    private int countLightsOn() {
        int count = 0;
        for (boolean[] row : grid) {
            for (boolean b : row) {
                if (b) {
                    count++;
                }
            }
        }
        return count;
    }

    private int calculateTotalLights() {
        return Arrays.stream(lights).mapToInt(row -> Arrays.stream(row).sum()).sum();
    }

    private void executeCommand(String line, boolean part1) {
        Matcher matcher = pattern.matcher(line);

        if (matcher.matches() && matcher.groupCount() == 5) {
            int fromX = Integer.parseInt(matcher.group(2));
            int fromY = Integer.parseInt(matcher.group(3));
            int toX = Integer.parseInt(matcher.group(4));
            int toY = Integer.parseInt(matcher.group(5));

            if (part1) {
                changeLights(matcher.group(1), fromX, toX, fromY, toY);
            } else {
                changeBrightness(matcher.group(1), fromX, toX, fromY, toY);
            }
        }
    }

    private void changeLights(String command, int fromX, int toX, int fromY, int toY) {
        for (int y = fromY; y <= toY; y++) {
            for (int x = fromX; x <= toX; x++) {
                grid[y][x] = switch (command) {
                    case "turn on" -> true;
                    case "turn off" -> false;
                    default -> !grid[y][x];
                };
            }
        }
    }

    private void changeBrightness(String command, int fromX, int toX, int fromY, int toY) {
        for (int y = fromY; y <= toY; y++) {
            for (int x = fromX; x <= toX; x++) {
                lights[y][x] = switch (command) {
                    case "turn on" -> lights[y][x] + 1;
                    case "turn off" -> Math.max(0, lights[y][x] - 1);
                    default -> lights[y][x] + 2;
                };
            }
        }
    }

    public static void main(String[] args) {
        new Day06().main();
    }
}
