package day04

import aoc.loadExample
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day04Test {
    val input: String = loadExample("day04.txt")

    @Test
    fun part1Example() {
        val subject = Day04()

        assertThat(subject.part1(input))
            .isEqualTo(2)
    }
}