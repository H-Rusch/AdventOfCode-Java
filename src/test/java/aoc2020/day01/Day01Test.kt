package aoc2020.day01

import aoc.loadExample
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day01Test {

    @Test
    fun part1Example() {
        val input = loadExample(2020, "day01.txt")
        val subject = Day01()

        val result = subject.part1(input)

        assertThat(result)
            .isEqualTo(514579)
    }

    @Test
    fun part2Example() {
        val input = loadExample(2020, "day01.txt")
        val subject = Day01()

        val result = subject.part2(input)

        assertThat(result)
            .isEqualTo(241861950)
    }
}