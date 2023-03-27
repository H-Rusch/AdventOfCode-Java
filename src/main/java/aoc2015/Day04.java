package aoc2015;

import jakarta.xml.bind.DatatypeConverter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class Day04 extends Day {

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
    public String part1(String input) {
        input = input.strip();

        int number = 1;
        while (true) {
            if (testHash(input, number, "00000")) {
                break;
            }

            number++;
        }

        return String.valueOf(number);
    }

    @Override
    public String part2(String input) {
        input = input.strip();

        int number = 1;
        while (true) {
            if (testHash(input, number, "000000")) {
                break;
            }

            number++;
        }

        return String.valueOf(number);
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
