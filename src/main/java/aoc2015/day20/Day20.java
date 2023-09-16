package aoc2015.day20;

import aoc2015.Day2015;


public class Day20 extends Day2015 {

    private int[] housePresents;

    public Day20() {
        super(20);
    }

    @Override
    public Object part1(String input) {
        var targetPresents = Integer.parseInt(input.trim());
        fillPresentArray(targetPresents);

        return findLowestHouseNumber(targetPresents);
    }

    @Override
    public Object part2(String input) {
        return null;
    }


    private void fillPresentArray(int targetPresents) {
        this.housePresents = new int[targetPresents / 10];

        for (int i = 1; i < housePresents.length; i++) {
            for (int j = i; j < housePresents.length; j += i) {
                housePresents[j] += 10 * i;
            }
        }
    }

    private int findLowestHouseNumber(int targetPresents) {
        for (int i = 0; i < housePresents.length; i++) {
            if (housePresents[i] >= targetPresents) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new Day20().main();
    }
}
