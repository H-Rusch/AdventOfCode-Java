package day04

import aoc15.loadExample
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day04Test {

    val filename = "Day04.txt"

    @Test
    fun part1Example() {
        val input = loadExample(filename)
        val subject = Day04()

        val result = subject.part1(input)

        assertThat(result).isEqualTo(13)
    }

    @Test
    fun part2Example() {
        val input = loadExample(filename)
        val subject = Day04()

        val result = subject.part2(input)

        assertThat(result).isEqualTo(43)
    }
}
