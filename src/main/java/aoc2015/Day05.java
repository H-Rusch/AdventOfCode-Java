package aoc2015;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

class Day05 extends Day {

    private final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    // for part 1
    private final Pattern threeVowels = Pattern.compile("([aeiou].*){3,}");
    private final Pattern sameLetterTwice = Pattern.compile("(.)\\1");
    private final Pattern forbidden = Pattern.compile("ab|cd|pq|xy");

    // for part 2
    private final Pattern pairAppearsTwice = Pattern.compile("(..).*\\1");
    private final Pattern sameLetterWithOneBetween = Pattern.compile("(.).\\1");


    Day05() {
        super(5);
    }


    @Override
    public String part1(String input) {
        long count = input.lines().filter(this::isNice).count();

        return String.valueOf(count);
    }

    @Override
    public String part2(String input) {
        long count = input.lines().filter(this::isReallyNice).count();

        return String.valueOf(count);
    }

    /**
     * Nice string:
     * - contains 3 vowels
     * - at least one character that appears twice in a row
     * - does not contain [ab, cd, pq, xy]
     */
    protected boolean isNice(String input) {
        return threeVowels.matcher(input).find()
                && sameLetterTwice.matcher(input).find()
                && !forbidden.matcher(input).find();
    }

    protected boolean isNiceString(String input) {
        int vowelCount = vowels.contains(input.charAt(0)) ? 1 : 0;
        boolean twice = false;

        for (int i = 1; i < input.length(); i++) {
            char char1 = input.charAt(i - 1);
            char char2 = input.charAt(i);
            if (vowels.contains(char2)) {
                vowelCount++;
            }

            if (char1 == char2) {
                twice = true;
            }

            if ((char1 == 'a' && char2 == 'b')
                    || (char1 == 'c' && char2 == 'd')
                    || (char1 == 'p' && char2 == 'q')
                    || (char1 == 'x' && char2 == 'y')) {
                return false;
            }
        }

        return vowelCount >= 3 && twice;
    }


    /**
     * Really nice string:
     * - contains a pair of two letter that appear at least twice in the string without overlapping
     * - contains at least one letter which repeats with exactly one letter in between
     */
    protected boolean isReallyNice(String input) {
        return pairAppearsTwice.matcher(input).find()
                && sameLetterWithOneBetween.matcher(input).find();
    }

    protected boolean isReallyNiceString(String input) {
        return repeatingWithOneInBetween(input) && containsNonOverlappingPair(input);
    }

    private boolean containsNonOverlappingPair(String input) {
        Map<String, Integer> pairs = new HashMap<>();

        for (int i = 0; i < input.length() - 1; i++) {
            String substring = input.substring(i, i + 2);
            if (pairs.containsKey(substring) && pairs.get(substring) != i - 1) {
                return true;
            }
            pairs.putIfAbsent(substring, i);
        }

        return false;
    }

    private boolean repeatingWithOneInBetween(String input) {
        for (int i = 0; i < input.length() - 2; i++) {
            if (input.charAt(i) == input.charAt(i + 2)) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        new Day05().main();
    }
}
