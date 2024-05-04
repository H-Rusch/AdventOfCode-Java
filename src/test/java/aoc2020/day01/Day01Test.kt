package aoc2020.day01

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import util.days.InputFetcher

class Day01Test {

    @Test
    fun part1_example() {
        val input = InputFetcher.loadExample(2020, "day01.txt")
        val subject = Day01()

        val result = subject.part1(input)

        assertThat(result)
            .isEqualTo(514579)
    }

    @Test
    fun part2_example() {
        val input = InputFetcher.loadExample(2020, "day01.txt")
        val subject = Day01()

        val result = subject.part2(input)

        assertThat(result)
            .isEqualTo(241861950)
    }
}