package aoc2020.day03

import aoc.loadExample
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day03Test {
    val input: String = loadExample(2020, "day03.txt")

    @Test
    fun part1_example() {
        val subject = Day03()

        assertThat(subject.part1(input))
            .isEqualTo(7)
    }

    @Test
    fun part2_example() {
        val subject = Day03()

        assertThat(subject.part2(input))
            .isEqualTo(336)
    }
}