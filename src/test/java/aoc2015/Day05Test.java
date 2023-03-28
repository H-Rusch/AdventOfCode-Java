package aoc2015;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day05Test {

    @Test
    void part1Test() {
        var day = new Day05();

        assertTrue(day.isNiceString("ugknbfddgicrmopn"));
        assertTrue(day.isNiceString("aaa"));
        assertFalse(day.isNiceString("jchzalrnumimnmhp"));
        assertFalse(day.isNiceString("haegwjzuvuyypxyu"));
        assertFalse(day.isNiceString("dvszwmarrgswjxmb"));

        assertTrue(day.isNice("aaa"));
        assertTrue(day.isNice("ugknbfddgicrmopn"));
        assertFalse(day.isNice("jchzalrnumimnmhp"));
        assertFalse(day.isNice("haegwjzuvuyypxyu"));
        assertFalse(day.isNice("dvszwmarrgswjxmb"));
    }

    @Test
    void part2Test() {
        var day = new Day05();

        assertTrue(day.isReallyNiceString("qjhvhtzxzqqjkmpb"));
        assertTrue(day.isReallyNiceString("xxyxx"));
        assertFalse(day.isReallyNiceString("uurcxstgmygtbstg"));
        assertFalse(day.isReallyNiceString("ieodomkazucvgmuy"));
        assertTrue(day.isReallyNiceString("sknufchjdvccccta"));
        assertTrue(day.isReallyNiceString("abaaaa"));
        assertFalse(day.isReallyNiceString("aaa"));

        assertTrue(day.isReallyNice("qjhvhtzxzqqjkmpb"));
        assertTrue(day.isReallyNice("xxyxx"));
        assertFalse(day.isReallyNice("uurcxstgmygtbstg"));
        assertFalse(day.isReallyNice("ieodomkazucvgmuy"));
        assertTrue(day.isReallyNice("sknufchjdvccccta"));
        assertTrue(day.isReallyNice("abaaaa"));
        assertFalse(day.isReallyNice("aaa"));
    }
}
