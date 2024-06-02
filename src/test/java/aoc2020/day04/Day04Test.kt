package aoc2020.day04

import aoc.loadExample
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day04Test {
    val input: String = loadExample(2020, "day04.txt")

    @Test
    fun part1_example() {
        val subject = Day04()

        assertThat(subject.part1(input))
            .isEqualTo(2)
    }
}