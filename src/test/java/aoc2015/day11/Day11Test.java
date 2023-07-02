package aoc2015.day11;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day11Test {

    @ParameterizedTest
    @MethodSource("newValidPasswordParameters")
    void part1Test(String input, String expectedOutput) {
        var day = new Day11();

        String output = (String) day.part1(input);

        assertEquals(expectedOutput, output);
    }

    private static Stream<Arguments> newValidPasswordParameters() {
        return Stream.of(
                Arguments.of("abcdefgh", "abcdffaa"),
                Arguments.of("ghijklmn", "ghjaabcc")
        );
    }


}
