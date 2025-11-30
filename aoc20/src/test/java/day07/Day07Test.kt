package day07

import aoc15.loadExample
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class Day07Test {

    val input: String = loadExample("day07_1.txt")

    private lateinit var subject: Day07

    @BeforeEach
    fun setUp() {
        subject = Day07()
    }

    @Test
    fun part1Example() {
        assertThat(subject.part1(input))
            .isEqualTo(4)
    }

    @ParameterizedTest
    @CsvSource(
        "day07_1.txt, 32",
        "day07_2.txt, 126"
    )
    fun part2Example(filename: String, expectedResult: Int) {
        val input = loadExample(filename)

        assertThat(subject.part2(input))
            .isEqualTo(expectedResult)
    }
}