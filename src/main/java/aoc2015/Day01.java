package aoc2015;

public class Day01 extends Day {

    Day01() {
        super(1);
    }

    @Override
    public String part1(String input) {
        int floor = 0;

        for (char c : input.toCharArray()) {
            if (c == '(') {
                floor += 1;
            } else {
                floor -= 1;
            }
        }

        return String.valueOf(floor);
    }

    @Override
    public String part2(String input) {
        int floor = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') {
                floor += 1;
            } else {
                floor -= 1;
            }

            if (floor == -1) {
                return String.valueOf(i + 1);
            }
        }

        return "";
    }

    public static void main(String[] args) {
        var day = new Day01();
        day.main();
    }
}
