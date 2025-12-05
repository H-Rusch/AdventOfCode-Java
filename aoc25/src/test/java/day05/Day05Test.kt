package day05

import aoc15.loadExample
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day05Test {

    val filename = "day05.txt"

    @Test
    fun part1Example() {
        val input = loadExample(filename)
        val subject = Day05()

        val result = subject.part1(input)

        assertThat(result).isEqualTo(3)
    }

    @Test
    fun part2Example() {
        val input = loadExample(filename)
        val subject = Day05()

        val result = subject.part2(input)

        assertThat(result).isEqualTo(14L)
    }

    @Test
    fun mergingRangesWorks() {
        val ranges = listOf(
            3L..5L,
            10L..14L,
            16L..20L,
            12L..18L,
            100L..200L,
            150L..175L
        )

        val result = mergeRanges(ranges)

        assertThat(result).isEqualTo(
            listOf(
                3L..5L,
                10L..20L,
                100L..200L
            )
        )
    }
}
