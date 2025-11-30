package aoc2020.day06

import aoc.loadExample
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day06Test {

    val input: String = loadExample(2020, "day06.txt")

    private lateinit var subject: Day06

    @BeforeEach
    fun setUp() {
        subject = Day06()
    }

    @Test
    fun part1Example() {
        assertThat(subject.part1(input))
            .isEqualTo(11)
    }

    @Test
    fun part2Example() {
        assertThat(subject.part2(input))
            .isEqualTo(6)
    }
}