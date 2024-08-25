package aoc2020.day11

import aoc.loadExample
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class Day11Test {

    private var subject: Day11 = Day11()

    private val input = loadExample(2020, "day11.txt")

    @Test
    fun part1_examples() {
        assertThat(subject.part1(input))
            .isEqualTo(37)
    }

    @Test
    fun part2_examples() {
        assertThat(subject.part2(input))
            .isEqualTo(26)
    }
}