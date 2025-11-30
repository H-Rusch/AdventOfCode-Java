package day03

import aoc15.loadExample
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day03Test {
    val input: String = loadExample("day03.txt")

    @Test
    fun part1Example() {
        val subject = Day03()

        assertThat(subject.part1(input))
            .isEqualTo(7)
    }

    @Test
    fun part2Example() {
        val subject = Day03()

        assertThat(subject.part2(input))
            .isEqualTo(336)
    }
}