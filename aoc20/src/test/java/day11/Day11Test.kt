package day11

import aoc15.loadExample
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day11Test {

    private var subject: Day11 = Day11()

    private val input = loadExample("day11.txt")

    @Test
    fun part1Examples() {
        assertThat(subject.part1(input))
            .isEqualTo(37)
    }

    @Test
    fun part2Examples() {
        assertThat(subject.part2(input))
            .isEqualTo(26)
    }
}