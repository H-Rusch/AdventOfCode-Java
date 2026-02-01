package day06

import aoc.loadExample
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day06Test {

    val filename = "day06.txt"

    @Test
    fun part1Example() {
        val input = loadExample(filename)
        val subject = Day06()

        val result = subject.part1(input)

        assertThat(result).isEqualTo(4277556L)
    }

    @Test
    fun part2Example() {
        val input = loadExample(filename)
        val subject = Day06()

        val result = subject.part2(input)

        assertThat(result).isEqualTo(3263827L)
    }
}
