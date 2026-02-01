package day10

import aoc.loadExample
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class Day10Test {

    private val year = 2020
    private var subject: Day10 = Day10()

    @ParameterizedTest
    @CsvSource(
        "day10_1.txt, 35",
        "day10_2.txt, 220"
    )
    fun part1Examples(filename: String, expectedResult: Int) {
        val input = loadExample(filename)

        assertThat(subject.part1(input))
            .isEqualTo(expectedResult)
    }

    @ParameterizedTest
    @CsvSource(
        "day10_1.txt, 8",
        "day10_2.txt, 19208"
    )
    fun part2Examples(filename: String, expectedResult: Long) {
        val input = loadExample(filename)

        assertThat(subject.part2(input))
            .isEqualTo(expectedResult)
    }
}