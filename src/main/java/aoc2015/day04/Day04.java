package aoc2015.day04;

import aoc2015.Day2015;
import jakarta.xml.bind.DatatypeConverter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class Day04 extends Day2015 {

    private final MessageDigest md;

    Day04() {
        super(4);
        try {
            this.md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer part1(String input) {
        input = input.strip();

        return findLowestNumber(input, "00000");
    }

    @Override
    public Integer part2(String input) {
        input = input.strip();

        return findLowestNumber(input, "000000");
    }

    private int findLowestNumber(String input, String searchFor) {
        int number = 1;
        while (!testHash(input, number, searchFor)) {
            number++;
        }

        return number;
    }

    private boolean testHash(String input, int number, String start) {
        String toHash = input + number;
        byte[] digest = md.digest(toHash.getBytes());
        String hashed = DatatypeConverter.printHexBinary(digest);

        return hashed.startsWith(start);
    }

    public static void main(String[] args) {
        new Day04().main();
    }
}
