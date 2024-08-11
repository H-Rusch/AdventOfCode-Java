package aoc2020.day08

import aoc.loadExample
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day08Test {

    val input: String = loadExample(2020, "day08.txt")

    private lateinit var subject: Day08

    @BeforeEach
    fun setUp() {
        subject = Day08()
    }

    @Test
    fun part1_example() {
        assertThat(subject.part1(input))
            .isEqualTo(5)
    }

    @Test
    fun part2_example() {
        assertThat(subject.part2(input))
            .isEqualTo(8)
    }
}