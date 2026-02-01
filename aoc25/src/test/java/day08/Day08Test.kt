package day08

import aoc.loadExample
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day08Test {

    val filename = "day08.txt"

    @Test
    fun part1Example() {
        val input = loadExample(filename)
        val subject = Day08()

        val result = subject.part1(input, 10)

        assertThat(result).isEqualTo(40)
    }

    @Test
    fun part2Example() {
        val input = loadExample(filename)
        val subject = Day08()

        val result = subject.part2(input)

        assertThat(result).isEqualTo(25272)
    }
}
