package day12

import aoc15.loadExample
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day12Test {

    val input = loadExample("day12.txt")
    val subject = Day12()

    @Test
    fun part1Example() {
        assertThat(subject.part1(input))
            .isEqualTo(25)
    }

    @Test
    fun part2Example() {
        assertThat(subject.part2(input))
            .isEqualTo(286)
    }
}