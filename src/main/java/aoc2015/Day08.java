package aoc2015;

public class Day08 extends Day {
    public Day08() {
        super(8);
    }

    @Override
    public Integer part1(String input) {
        return input.lines()
                .mapToInt(line -> codeChars(line) - stringChars(line))
                .sum();
    }

    @Override
    public Integer part2(String input) {
        return input.lines()
                .mapToInt(line -> encodedLength(line) - codeChars(line))
                .sum();
    }

    public int codeChars(String str) {
        return str.length();
    }

    public int stringChars(String str) {
        int count = 0;
        int i = 1;
        while (i < str.length() - 1) {
            if (str.charAt(i) == '\\') {
                i += str.charAt(i + 1) == 'x' ? 4 : 2;
            } else {
                i += 1;
            }
            count++;
        }

        return count;
    }

    public int encodedLength(String str) {
        int toEscapeCount = 0;
        for (char c : str.toCharArray()) {
            if (c == '\\' || c == '\"') {
                toEscapeCount++;
            }
        }

        return 2 + str.length() + toEscapeCount;
    }

    public static void main(String[] args) {
        new Day08().main();
    }
}
