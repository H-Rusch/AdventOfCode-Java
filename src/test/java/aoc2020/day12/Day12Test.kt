package aoc2020.day12

import aoc.loadExample
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class Day12Test {

    val input = loadExample(2020, "day12.txt")
    val subject = Day12()

    @Test
    fun part1_example() {
        assertThat(subject.part1(input))
            .isEqualTo(25)
    }

    @Test
    fun part2_example() {
        assertThat(subject.part2(input))
            .isEqualTo(286)
    }
}