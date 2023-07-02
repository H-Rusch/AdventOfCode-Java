package aoc2015.day10;

import aoc2015.Day2015;


class Day10 extends Day2015 {

    Day10() {
        super(10);
    }

    @Override
    public Object part1(String input) {
        return iterateSequence(input.trim(), 40).length();
    }

    @Override
    public Object part2(String input) {
        return iterateSequence(input.trim(), 50).length();
    }

    public String iterateSequence(String input, int times) {
        SequenceTransformer transformer = new SequenceTransformer(input.trim());

        for (int i = 0; i < times; i++) {
            transformer.transform();
        }

        return transformer.getSequence();
    }

    public static void main(String[] args) {
        new Day10().main();
    }
}
