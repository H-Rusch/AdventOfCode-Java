package aoc2015;

import util.days.AbstractDay;

import java.util.Random;

public class Day01 extends Day {

    public Day01() {
        super(1);
    }

    @Override
    public String part1(String input) {
        int res = 0;
        Random rand = new Random();
        for (int i = 0; i < 100000000; i++) {
            res += rand.nextInt(900000);
        }
        return String.valueOf(res);
    }

    @Override
    public String part2(String input) {
        return "";
    }

    public static void main(String[] args) {
        var day = new Day01();
        day.main();
    }
}
