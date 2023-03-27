package aoc2015;

import java.util.Arrays;

public class Day02 extends Day {

    Day02() {
        super(2);
    }

    @Override
    public String part1(String input) {
        int sum = input
                .lines()
                .mapToInt(line -> {
                    int[] dims = Arrays.stream(line.split("x")).mapToInt(Integer::valueOf).toArray();
                    int[] sides = new int[]{dims[0] * dims[1], dims[0] * dims[2], dims[1] * dims[2]};
                    Arrays.sort(sides);

                    return 2 * Arrays.stream(sides).sum() + sides[0];
                }).sum();

        return String.valueOf(sum);
    }

    @Override
    public String part2(String input) {
        int sum = input
                .lines()
                .mapToInt(line -> {
                    int[] dims = Arrays.stream(line.split("x")).mapToInt(Integer::valueOf).toArray();
                    Arrays.sort(dims);

                    return 2 * (dims[0] + dims[1]) + Arrays.stream(dims).reduce(1, (v1, v2) -> v1 * v2);
                }).sum();

        return String.valueOf(sum);
    }

    public static void main(String[] args) {
        new Day02().main();
    }
}
