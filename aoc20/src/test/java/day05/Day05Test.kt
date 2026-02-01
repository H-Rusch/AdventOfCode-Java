package day05

import aoc.loadExample
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class Day05Test {

    val input: String = loadExample("day05.txt")

    private lateinit var subject: Day05

    @BeforeEach
    fun setUp() {
        subject = Day05()
    }

    @ParameterizedTest
    @CsvSource(
        "FBFBBFFRLR, 357",
        "BFFFBBFRRR, 567",
        "FFFBBBFRRR, 119",
        "BBFFBBFRLL, 820",
    )
    fun testCalculateSquare(boardingPass: String, expectedResult: Int) {
        assertThat(subject.calculateSeatId(boardingPass))
            .isEqualTo(expectedResult)
    }

    @Test
    fun part1Example() {
        assertThat(subject.part1(input))
            .isEqualTo(820)
    }
}